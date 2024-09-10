package com.aqa.mobile.application.page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MainPage extends BasePage {


    @AndroidFindBy(accessibility = "Accessibility")
    private WebElement accessibilityTab;

    @AndroidFindBy(accessibility = "Preference")
    private WebElement preferenceTab;


    public void assertMainPageLoaded() {
        Assert.assertTrue(accessibilityTab.isDisplayed());
    }

    public void clickOnPreferenceTab() {
        preferenceTab.click();
    }
}
