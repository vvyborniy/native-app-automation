package com.aqa.mobile.config;


import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigCache;


@Config.Sources("classpath:environment.properties")
public interface Environment extends Config {

    Environment environment = ConfigCache.getOrCreate(Environment.class);

    @Config.Key("app.path")
    String appPath();

    @Config.Key("app.package")
    String appPackage();

    @Config.Key("driver.implicitWait")
    int implicitWait();

    @Config.Key("isRetryTest")
    boolean isRetryTest();

    @Config.Key("driver.newCommandTimeoutSeconds")
    int newCommandTimeout();

    @Config.Key("device.jsonPath")
    String devicesJsonPath();
}
