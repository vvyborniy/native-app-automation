package com.aqa.mobile.common;

import com.aqa.mobile.application.Application;
import com.aqa.mobile.driver.MobileDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;


public class BaseTest {

    protected Application application;

    @BeforeMethod(alwaysRun = true)
    public void setup(ITestResult testResult) {
        setupRetry(testResult);
        MobileDriver.initDriver();
        application = new Application();
        MobileDriver.setAppPackage();
    }

    @Step("Setup retry")
    private void setupRetry(ITestResult testResult) {
        testResult.getMethod().setRetryAnalyzerClass(RetryAnalyzer.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            Allure.addAttachment("screenshot on fail", "image/png", new ByteArrayInputStream(MobileDriver.makeScreenshot()), "png");
        }
        MobileDriver.killDriver();

        attachLogs();

    }

    @Step("Attached logs")
    @SneakyThrows
    private void attachLogs() {
        Allure.addAttachment("mobile logs", "text/*", new FileInputStream("logs/mobile.log"), ".log");
        Allure.addAttachment("appium logs", "text/*", new FileInputStream("logs/appium.log"), ".log");
    }


}
