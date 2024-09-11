package com.aqa.mobile.application.page.preferences;

import com.aqa.mobile.application.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class PreferenceMenuPage extends BasePage {


    @AndroidFindBy(id = "android:id/list")
    private WebElement listView;

    @AndroidFindBy(accessibility = "1. Preferences from XML")
    private WebElement preferenceFromXMLTab;

    @AndroidFindBy(accessibility = "2. Launching preferences")
    private WebElement launchingPreferencesTab;

    @AndroidFindBy(accessibility = "3. Preference dependencies")
    private WebElement preferenceDependenciesTab;

    @AndroidFindBy(accessibility = "5. Preferences from code")
    private WebElement preferenceFromCodeTab;


    @Step("Assert 'Preference Page' loaded")
    public void assertPageIsLoaded() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(preferenceFromXMLTab.isDisplayed(), "Preference Page isn't load");
        softAssert.assertTrue(listView.isDisplayed(), "Preference Page isn't load");
        softAssert.assertAll();
    }

    @Step("Go to 'Preference From Code page'")
    public void clickOnPreferenceFromCodeTab() {
        preferenceFromCodeTab.click();
    }

    @Step("Go to 'Launching Preferences page'")
    public void clickOnLaunchingPreferencesTab() {
        launchingPreferencesTab.click();
    }

    @Step("Go to 'Preference Dependencies page'")
    public void clickOnPreferenceDependenciesTab() {
        preferenceDependenciesTab.click();
    }
}
