package com.aqa.mobile.driver;

import com.aqa.mobile.common.device.model.MobileDevice;
import com.aqa.mobile.config.Environment;
import com.aqa.mobile.driver.appium.AppiumServer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;
import java.util.Optional;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MobileDriver {

    private static final ThreadLocal<AppiumDriver> APPIUM_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    private static String appPackage;

    public static void initDriver(MobileDevice deviceForTest) {
        try {
            AndroidDriver driver = new AndroidDriver(AppiumServer.getService(), CapabilitiesConfigurator.getAndroidCapabilities(deviceForTest));
            log.info("Driver is created.");
            APPIUM_DRIVER_THREAD_LOCAL.set(driver);
            enableImplicitWait();
        } catch (Exception e) {
            log.error("Catch exception during driver creating. Try to force stop Appium server.");
            deviceForTest.rebootDevice();
            throw e;
        }
    }

    public static void killDriver() {
        log.info("Try to close driver");
        Optional.ofNullable(APPIUM_DRIVER_THREAD_LOCAL.get()).ifPresent((AppiumDriver driver) -> {
            driver.quit();
            APPIUM_DRIVER_THREAD_LOCAL.remove();
            log.info("Driver is closed");
        });
        AppiumServer.stopServer();
    }

    public static AppiumDriver getAppiumDriver() {
        return APPIUM_DRIVER_THREAD_LOCAL.get();
    }

    public static void setImplicitWait(Integer waitInSec) {
        getAppiumDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(waitInSec));
    }

    public static void enableImplicitWait() {
        getAppiumDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Environment.environment.implicitWait()));
    }

    public static void disableImplicitWait() {
        setImplicitWait(0);
    }

    @Step("Terminate App")
    public static void terminateApp() {
        ((AndroidDriver) getAppiumDriver()).terminateApp(appPackage);
    }

    public static String getCurrentPackage() {
        return ((AndroidDriver) getAppiumDriver()).getCurrentPackage();
    }

    @Step("Activate App")
    public static void activateApp() {
        ((AndroidDriver) getAppiumDriver()).activateApp(appPackage);
    }

    @Step("Restart App")
    public static void restartApp() {
        terminateApp();
        activateApp();
        log.info("App was restarted");
    }

    public static void setAppPackage() {
        appPackage = getCurrentPackage();
        log.info("Set app package: " + appPackage);
    }

    @Step("Hide keyboard")
    public static void hideKeyboard() {
        ((AndroidDriver) getAppiumDriver()).hideKeyboard();
    }

    @Step("Make screenshot")
    public static byte[] makeScreenshot() {
        return ((TakesScreenshot) getAppiumDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Get page source")
    public static String getPageSource() {
        return getAppiumDriver().getPageSource();
    }
}
