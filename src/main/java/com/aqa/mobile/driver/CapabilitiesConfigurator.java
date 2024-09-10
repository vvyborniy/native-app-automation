package com.aqa.mobile.driver;

import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.time.Duration;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CapabilitiesConfigurator {

    public static UiAutomator2Options getAndroidCapabilities() {
        UiAutomator2Options desiredCapabilities = new UiAutomator2Options();

        //TODO to Environment variables
        String appPath = "apps/ApiDemos.apk";

        //TODO to separate object
        String udid = "emulator-5554";
        String deviceName = "emulator-5554";

        desiredCapabilities
                .setAutomationName("uiautomator2")
                .setPlatformName("android")
                .setDeviceName(deviceName)
                .setUdid(udid)
//                .setSystemPort() // set if ports provided by default conflict
                .setNewCommandTimeout(Duration.ofSeconds(60))
                .setApp(new File(appPath).getAbsolutePath())
                .setAdbExecTimeout(Duration.ofMillis(120000))
                .fullReset()
                .setNoReset(false);

        log.info("Android capabilities:\n" + desiredCapabilities);
        return desiredCapabilities;
    }
}