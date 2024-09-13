package com.aqa.mobile.application.page.animation;

import com.aqa.mobile.application.page.BasePage;
import com.aqa.mobile.common.helper.ImageComparisonHelper;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayInputStream;

public class SeekingPage extends BasePage {


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Animation/Seeking']")
    private WebElement title;

    @AndroidFindBy(id = "io.appium.android.apis:id/seekBar")
    private WebElement seekBar;

    @AndroidFindBy(xpath = "//*[@resource-id='io.appium.android.apis:id/container']//android.view.View")
    private WebElement ballView;


    @Step("Assert 'SeekingPage' loaded")
    public void assertPageIsLoaded() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isElementDisplayed(title), "SeekingPage isn't load");
        softAssert.assertTrue(isElementDisplayed(ballView), "SeekingPage isn't load");
        softAssert.assertAll();
    }

    @Step("Move seekBar pointer")
    public void moveSeekBarPointer() {
        //min value to change ball location is 2
        seekBar.sendKeys("100");
    }

    @Step("Capture ball view screenshot")
    public byte[] getScreenshotOfBallView() {
        return ballView.getScreenshotAs(OutputType.BYTES);
    }

    @Step("Move seekBar pointer and Assert changed Ball location on page")
    public void moveSeekBarPointerAndAssertChangedBallLocation() {
        byte[] firstShot = this.getScreenshotOfBallView();
        Allure.addAttachment("screenshot *before* moving seekBar pointer", new ByteArrayInputStream(firstShot));
        this.moveSeekBarPointer();
        byte[] secondShot = this.getScreenshotOfBallView();
        Allure.addAttachment("screenshot *after* moving seekBar pointer", new ByteArrayInputStream(secondShot));
        double thresholdPercentage = 0.01;
        Assert.assertFalse(ImageComparisonHelper.areImagesSame(firstShot, secondShot,
                        "result-comparing.png", thresholdPercentage),
                "Ball didn't change location. See details in screenshots. Used threshold: " + thresholdPercentage + "%.");
    }
}
