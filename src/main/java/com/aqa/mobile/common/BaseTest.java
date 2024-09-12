package com.aqa.mobile.common;

import com.aqa.mobile.application.Application;
import com.aqa.mobile.common.device.DeviceManager;
import com.aqa.mobile.common.device.model.MobileDevice;
import com.aqa.mobile.common.helper.CommandExcHelper;
import com.aqa.mobile.driver.MobileDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;

import static com.aqa.mobile.driver.MobileDriver.getAppiumDriver;


@Log4j2
public class BaseTest {

    protected Application application;
    private final DeviceManager deviceManager = new DeviceManager();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuit() {
        CommandExcHelper.runDevices();
    }


    @BeforeMethod(alwaysRun = true)
    public void setup(ITestResult testResult) {
        setupRetry(testResult);
        long threadId = Thread.currentThread().getId();
        Thread.currentThread().setName(testResult.getMethod().getMethodName() + threadId);
        MobileDevice deviceForTest = deviceManager.getDeviceForTest();
        MobileDriver.initDriver(deviceForTest);
        application = new Application();
        MobileDriver.setAppPackage();
    }

    @Step("Setup retry")
    private void setupRetry(ITestResult testResult) {
        testResult.getMethod().setRetryAnalyzerClass(RetryAnalyzer.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {
        if (!testResult.isSuccess() && getAppiumDriver() != null) {
            Allure.addAttachment("screenshot on fail", "image/png", new ByteArrayInputStream(MobileDriver.makeScreenshot()), "png");
            Allure.addAttachment("page source on fail", MobileDriver.getPageSource());
        }
        MobileDriver.killDriver();
        deviceManager.freeDevice();


    }

    @AfterSuite(alwaysRun = true)
    public void afterSuit() {
        CommandExcHelper.killAllEmulators();
    }


}
