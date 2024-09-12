package com.aqa.mobile.driver;

import com.aqa.mobile.common.device.model.MobileDevice;
import com.aqa.mobile.config.Environment;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.time.Duration;

import static com.aqa.mobile.config.Environment.environment;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CapabilitiesConfigurator {


    public static UiAutomator2Options getAndroidCapabilities(MobileDevice deviceForTest) {
        UiAutomator2Options desiredCapabilities = new UiAutomator2Options();

        desiredCapabilities
                .setAutomationName("uiautomator2")
                .setPlatformName("android")
                .setDeviceName(deviceForTest.getDeviceName())
                .setUdid(deviceForTest.getUdid())
                .setPlatformVersion(deviceForTest.getPlatformVersion())
//                .setSystemPort() // set if ports provided by default conflict
                .setNewCommandTimeout(Duration.ofSeconds(environment.newCommandTimeout()))
                .setApp(new File(environment.appPath()).getAbsolutePath())
                .setAdbExecTimeout(Duration.ofMillis(120000))
                .fullReset()
                .setNoReset(false)
                .setAppWaitPackage(Environment.environment.appPackage());

        log.info("Android capabilities:\n" + desiredCapabilities);
        return desiredCapabilities;
    }
}