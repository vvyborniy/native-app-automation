package com.aqa.mobile;

import com.aqa.mobile.driver.MobileDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        MobileDriver.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        MobileDriver.killDriver();
    }


}
