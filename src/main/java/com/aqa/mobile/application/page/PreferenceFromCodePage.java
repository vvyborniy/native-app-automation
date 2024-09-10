package com.aqa.mobile.application.page;

import io.appium.java_client.pagefactory.AndroidFindBy;
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


    public void assertPreferencePageLoaded() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(innerLayout.isDisplayed());
        softAssert.assertTrue(checkbox.isDisplayed());
        softAssert.assertTrue(title.isDisplayed());
        softAssert.assertAll();
    }

    public void checkAllCheckboxes() {
        for (int i = 0; i < checkboxes.size(); i++) {
            if (!isElementChecked(checkboxes.get(i))) {
                checkboxes.get(i).click();
            }
        }
    }

    public void verifyCheckedAllCheckboxes() {
        SoftAssert softAssert = new SoftAssert();
        for (WebElement checkbox : checkboxes) {
            softAssert.assertTrue(isElementChecked(checkbox));
        }
        softAssert.assertAll();
    }

    public void checkAllSwitchWidgets() {
        for (int i = 0; i < switchWidgets.size(); i++) {
            if (!isElementChecked(switchWidgets.get(i))) {
                switchWidgets.get(i).click();
            }
        }
    }

    public void verifyCheckedAllSwitchWidgets() {
        SoftAssert softAssert = new SoftAssert();
        for (WebElement switchWidget : switchWidgets) {
            softAssert.assertTrue(isElementChecked(switchWidget));
        }
        softAssert.assertAll();
    }
}
