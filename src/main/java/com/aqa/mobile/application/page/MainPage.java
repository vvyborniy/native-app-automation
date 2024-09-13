package com.aqa.mobile.application.page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MainPage extends BasePage {

    @AndroidFindBy(accessibility = "Preference")
    private WebElement preferenceTab;

    @AndroidFindBy(accessibility = "Animation")
    private WebElement animationTab;

    @AndroidFindBy(accessibility = "App")
    private WebElement appTab;


    @Step("Assert 'Main page' loaded")
    public void assertPageIsLoaded() {
        Assert.assertTrue(isElementDisplayed(preferenceTab), "Main page isn't load");
    }

    @Step("Go to 'Preference page'")
    public void clickOnPreferenceTab() {
        preferenceTab.click();
    }

    @Step("Go to 'Animation page'")
    public void clickOnAnimationTab() {
        animationTab.click();
    }

    @Step("Go to 'App menu page'")
    public void clickOnAppTab() {
        appTab.click();
    }
}
