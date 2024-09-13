package com.aqa.mobile.driver.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.util.Optional;

import static java.lang.String.format;

@Log4j2
public final class AppiumServer {

    private static final String APPIUM_LOG_LEVEL = "info";
    private static final String IP_ADDRESS = "127.0.0.1";
    public static final ThreadLocal<AppiumDriverLocalService> DRIVER_SERVICE_THREAD_LOCAL = new ThreadLocal<>();

    public static AppiumDriverLocalService getService() {
        if (DRIVER_SERVICE_THREAD_LOCAL.get() == null) {
            startServer();
        }
        return DRIVER_SERVICE_THREAD_LOCAL.get();
    }

    private static void startServer() {
        DRIVER_SERVICE_THREAD_LOCAL.set(new AppiumServiceBuilder()
                .withIPAddress(IP_ADDRESS)
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, APPIUM_LOG_LEVEL)
                .withLogFile(new File("logs/appium.log"))
                .build());
        log.info("Try to start Appium server");
        Optional.ofNullable(DRIVER_SERVICE_THREAD_LOCAL.get()).ifPresent(AppiumDriverLocalService::start);

        log.info(format("Appium server running status is [%s].",
                DRIVER_SERVICE_THREAD_LOCAL.get().isRunning()));
    }

    public static void stopServer() {
        Optional.ofNullable(DRIVER_SERVICE_THREAD_LOCAL.get()).ifPresent(AppiumDriverLocalService::stop);
        DRIVER_SERVICE_THREAD_LOCAL.remove();
        log.info("Appium server has been stopped");
    }
}
