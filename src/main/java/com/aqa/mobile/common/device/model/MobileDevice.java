package com.aqa.mobile.common.device.model;

import com.aqa.mobile.common.helper.CommandExcHelper;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.time.Duration;
import java.util.List;

import static java.lang.String.format;

@Log4j2
@Data
public class MobileDevice {

    String deviceName;
    String platformVersion;
    String udid;


    @Step("Reboot device")
    public void rebootDevice() {
        log.info("Try to reboot device through ADB command.");
        String out = CommandExcHelper.runCommandAndGetOutput("adb -s %s reboot".formatted(udid));
        log.info(out);
        waitForWakeup();
    }

    private void uninstallAppiumApp() {
        uninstallApp("io.appium.settings");
        uninstallApp("io.appium.uiautomator2.server");
        uninstallApp("io.appium.uiautomator2.server.test");
    }

    private void uninstallApp(String appPackage) {
        CommandExcHelper.runCommandAndGetOutput("adb -s %s uninstall %s".formatted(this.udid, appPackage));
    }

    @SneakyThrows
    private void waitForWakeup() {
        Thread.sleep(Duration.ofSeconds(30).toMillis()); // wait for device restart
        for (int i = 0; i < 9; i++) {
            if (this.isDeviceInListOfActiveDevices()) {
                return;
            }
            Thread.sleep(Duration.ofSeconds(10).toMillis()); // wait for device restart
        }
        throw new IllegalStateException(format("Device '%s' isn't received after reboot", this.getUdid()));
    }

    private boolean isDeviceInListOfActiveDevices() {
        List<String> devicesOutput = List.of(CommandExcHelper.runCommandAndGetOutput("adb devices").split("\n"));

        return devicesOutput.stream()
                .anyMatch(line -> line.contains(udid) && !line.contains("offline"));
    }
}
