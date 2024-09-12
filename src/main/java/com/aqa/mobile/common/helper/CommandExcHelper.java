package com.aqa.mobile.common.helper;

import com.aqa.mobile.config.Environment;
import io.qameta.allure.Step;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CommandExcHelper {


    public static String runCommandAndGetOutput(String command) {
        try {
            Process p = Runtime.getRuntime().exec(command);
            p.waitFor();
            InputStream is = p.exitValue() == 0 ? p.getInputStream() : p.getErrorStream();
            return new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            log.error("Exception during execution command: " + command);
            throw new RuntimeException(e);
        }
    }

    @Step("Run devices")
    public static void runDevices() {
        CommandExcHelper.runCommandAndGetOutput("/bin/sh start-emulator.sh " + Environment.environment.threadCount());
    }

    @Step("Kill all emulators")
    public static void killAllEmulators() {
        CommandExcHelper.runCommandAndGetOutput("/bin/sh kill-emulator.sh");
    }
}
