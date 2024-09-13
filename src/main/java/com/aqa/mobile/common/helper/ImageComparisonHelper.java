package com.aqa.mobile.common.helper;

import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nu.pattern.OpenCV;
import org.json.JSONObject;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ImageComparisonHelper {

    static {
        OpenCV.loadLocally();
    }

    public static boolean areImagesSame(byte[] imageBytes1, byte[] imageBytes2, String resultImageName, double thresholdPercentage) {
        // Load images
        Mat img1 = Imgcodecs.imdecode(new MatOfByte(imageBytes1), Imgcodecs.IMREAD_COLOR);
        Mat img2 = Imgcodecs.imdecode(new MatOfByte(imageBytes2), Imgcodecs.IMREAD_COLOR);

        if (img1.empty() || img2.empty()) {
            log.error("Error loading images to compare.");
            return false;
        }

        // Ensure images have the same size
        if (!img1.size().equals(img2.size())) {
            log.info("Images are not of the same size.");
            return false;
        }

        // Convert images to grayscale
        Mat gray1 = new Mat();
        Mat gray2 = new Mat();
        Imgproc.cvtColor(img1, gray1, Imgproc.COLOR_BGR2GRAY);
        Imgproc.cvtColor(img2, gray2, Imgproc.COLOR_BGR2GRAY);

        // Compute the absolute difference between the images
        Mat diff = new Mat();
        Core.absdiff(gray1, gray2, diff);

        // Apply a binary threshold to highlight differences
        Mat thresh = new Mat();
        Imgproc.threshold(diff, thresh, 30, 255, Imgproc.THRESH_BINARY);

        // Calculate the percentage of differing pixels
        double totalPixels = img1.size().area();
        double differingPixels = Core.countNonZero(diff);
        double differencePercentage = (differingPixels / totalPixels) * 100;

        // Determine if images are considered the same based on the threshold
        boolean areSame = differencePercentage < thresholdPercentage;

        // Convert threshold image to color (Red for differences)
        Mat diffColor = new Mat(img1.size(), img1.type(), new Scalar(0, 0, 255)); // Red color
        img1.copyTo(diffColor, thresh);

        // Create a final result image by merging img1 and the diffColor image
        Mat result = new Mat();
        Core.addWeighted(img1, 0.7, diffColor, 0.3, 0, result);

        // Save the result
        if (resultImageName != null) {
            Imgcodecs.imwrite(resultImageName, result);
            try {
                Path resultImagePath = Paths.get(resultImageName);
                byte[] differ = Files.readAllBytes(resultImagePath);
                // Encode the data, wrap in a JSON, encode as bytes
                String content = new JSONObject()
                        .put("expected", "data:image/png;base64,"
                                + Base64.getEncoder().encodeToString(imageBytes1))
                        .put("actual", "data:image/png;base64,"
                                + Base64.getEncoder().encodeToString(imageBytes2))
                        .put("diff", "data:image/png;base64,"
                                + Base64.getEncoder().encodeToString(differ))
                        .toString();

                // Attach to the test report
                Allure.addAttachment("Screenshot diff",
                        "application/vnd.allure.image.diff",
                        content);
                Files.deleteIfExists(resultImagePath);
            } catch (IOException e) {
                log.error("Error during saving image after comparing.");
                throw new RuntimeException(e);
            }
        }

        log.info("Difference percentage: " + differencePercentage + "%");
        return areSame;
    }
}