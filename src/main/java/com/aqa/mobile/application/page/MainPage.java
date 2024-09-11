package com.aqa.mobile.application.page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MainPage extends BasePage {


    @AndroidFindBy(accessibility = "Accessibility")
    private WebElement accessibilityTab;

    @AndroidFindBy(accessibility = "Preference")
    private WebElement preferenceTab;

    @AndroidFindBy(accessibility = "Animation")
    private WebElement animationTab;


    @Step("Assert 'Main page' loaded")
    public void assertPageIsLoaded() {
        Assert.assertTrue(accessibilityTab.isDisplayed(), "Main page isn't load");
    }

    @Step("Go to 'Preference page'")
    public void clickOnPreferenceTab() {
        preferenceTab.click();
    }

    @Step("Go to 'Animation page'")
    public void clickOnAnimationTab() {
        animationTab.click();
    }
}
