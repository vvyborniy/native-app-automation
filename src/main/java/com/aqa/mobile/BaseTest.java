package com.aqa.mobile;

import com.aqa.mobile.application.page.MainPage;
import com.aqa.mobile.application.page.PreferenceFromCodePage;
import com.aqa.mobile.application.page.PreferencePage;
import com.aqa.mobile.driver.MobileDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected MainPage mainPage;
    protected PreferencePage preferencePage;
    protected PreferenceFromCodePage preferenceFromCodePage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        MobileDriver.initDriver();
        // TODO
        mainPage = new MainPage();
        preferencePage = new PreferencePage();
        preferenceFromCodePage = new PreferenceFromCodePage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        MobileDriver.killDriver();
    }


}
