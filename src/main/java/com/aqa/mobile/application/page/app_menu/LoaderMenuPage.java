package com.aqa.mobile.application.page.app_menu;

import com.aqa.mobile.application.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class LoaderMenuPage extends BasePage {

    @AndroidFindBy(id = "android:id/list")
    private WebElement innerLayout;

    @AndroidFindBy(accessibility = "Custom")
    private WebElement customTab;

    @Step("Assert 'LoaderMenu page' loaded")
    public void assertPageIsLoaded() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isElementDisplayed(innerLayout), "LoaderMenuPage isn't load");
        softAssert.assertTrue(isElementDisplayed(customTab), "LoaderMenuPage isn't load");
        softAssert.assertAll();
    }

    @Step("Go to 'Custom page'")
    public void clickOnCustomTab() {
        customTab.click();
    }
}
