package com.aqa.mobile.application.page.app_menu;

import com.aqa.mobile.application.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class AppMenuPage extends BasePage {

    @AndroidFindBy(id = "android:id/list")
    private WebElement innerLayout;

    @AndroidFindBy(accessibility = "Loader")
    private WebElement loaderTab;

    @Step("Assert 'AppMenu page' loaded")
    public void assertPageIsLoaded() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(innerLayout.isDisplayed(), "AppMenuPage isn't load");
        softAssert.assertTrue(loaderTab.isDisplayed(), "AppMenuPage isn't load");
        softAssert.assertAll();
    }

    @Step("Go to 'LoaderMenu page'")
    public void clickOnLoaderTab() {
        loaderTab.click();
    }
}
