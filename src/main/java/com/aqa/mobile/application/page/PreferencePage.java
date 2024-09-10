package com.aqa.mobile.application.page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PreferencePage extends BasePage {


    @AndroidFindBy(accessibility = "1. Preferences from XML")
    private WebElement preferenceFromXMLTab;

    @AndroidFindBy(accessibility = "5. Preferences from code")
    private WebElement preferenceFromCodeTab;


    public void assertPreferencePageLoaded() {
        Assert.assertTrue(preferenceFromXMLTab.isDisplayed());
    }

    public void clickOnPreferenceFromCodeTab() {
        preferenceFromCodeTab.click();
    }
}
