package com.aqa.mobile.application.page.preferences;

import com.aqa.mobile.application.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PreferenceFromCodePage extends BasePage {


    @AndroidFindBy(id = "android:id/headers")
    private WebElement innerLayout;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference/5. Preferences from code']")
    private WebElement title;

    @AndroidFindBy(id = "android:id/checkbox")
    private WebElement checkbox;

    @AndroidFindBy(id = "android:id/checkbox")
    private List<WebElement> checkboxes;

    @AndroidFindBy(id = "android:id/switch_widget")
    private List<WebElement> switchWidgets;


    @Step("Assert 'PreferenceFromCodePage' loaded")
    public void assertPageIsLoaded() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(innerLayout.isDisplayed(), "PreferenceFromCodePage isn't load");
        softAssert.assertTrue(checkbox.isDisplayed(), "PreferenceFromCodePage isn't load");
        softAssert.assertTrue(title.isDisplayed(), "PreferenceFromCodePage isn't load");
        softAssert.assertAll();
    }

    @Step("Click on all checkboxes on 'PreferenceFromCodePage'")
    public void enableAllCheckboxes() {
        for (int i = 0; i < checkboxes.size(); i++) {
            if (!isElementChecked(checkboxes.get(i))) {
                checkboxes.get(i).click();
            }
        }
    }

    @Step("Verify that all checkboxes enabled")
    public void verifyCheckedAllCheckboxes() {
        SoftAssert softAssert = new SoftAssert();
        for (WebElement checkbox : checkboxes) {
            softAssert.assertTrue(isElementChecked(checkbox), "Checkbox isn't selected");
        }
        softAssert.assertAll();
    }

    @Step("Click on all switches on 'PreferenceFromCodePage'")
    public void enableAllSwitchWidgets() {
        for (int i = 0; i < switchWidgets.size(); i++) {
            if (!isElementChecked(switchWidgets.get(i))) {
                switchWidgets.get(i).click();
            }
        }
    }

    @Step("Verify that all switches enabled")
    public void verifyCheckedAllSwitchWidgets() {
        SoftAssert softAssert = new SoftAssert();
        for (WebElement switchWidget : switchWidgets) {
            softAssert.assertTrue(isElementChecked(switchWidget), "Checkbox isn't selected");
        }
        softAssert.assertAll();
    }
}
