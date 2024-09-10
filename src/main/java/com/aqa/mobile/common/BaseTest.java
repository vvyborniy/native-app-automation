package com.aqa.mobile.common;

import com.aqa.mobile.application.Application;
import com.aqa.mobile.driver.MobileDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Application application;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        MobileDriver.initDriver();
        application = new Application();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        MobileDriver.killDriver();
    }


}
