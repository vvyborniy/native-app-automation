package com.aqa.mobile.application.page.preferences;

import com.aqa.mobile.application.page.BasePage;
import com.aqa.mobile.common.helper.TextHelper;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static java.lang.String.format;

public class LaunchingPreferencesPage extends BasePage {


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference/2. Launching preferences']")
    private WebElement title;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Launch PreferenceActivity']")
    private WebElement launchPreferenceActivityButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'The counter value is')]")
    private WebElement counterTextView;


    @Step("Assert 'LaunchingPreferencesPage' loaded")
    public void assertPageIsLoaded() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isElementDisplayed(launchPreferenceActivityButton), "LaunchingPreferencesPage isn't load");
        softAssert.assertTrue(isElementDisplayed(title), "LaunchingPreferencesPage isn't load");
        softAssert.assertAll();
    }

    @Step("Tap 'Launch PreferenceActivity' button")
    public void clickOnLaunchPreferenceActivityButton() {
        launchPreferenceActivityButton.click();
    }

    public int getCounterValue() {
        return TextHelper.getFirstNumberFromText(counterTextView.getText());
    }

    @Step("Verify counter value is increased by [{value}]")
    public void verifyIncreaseCounterBy(int times, int startValue) {
        int current = this.getCounterValue();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(current, startValue, format("Counter doesn't change value on click." +
                "Expected current > start, but got current=%s and start=%s, performed clicks=%s", current, startValue, times));
        softAssert.assertTrue(current > startValue, format("Counter value did not increase on click. " +
                "Expected current > start, but got current=%s and start=%s, performed clicks=%s", current, startValue, times));
        softAssert.assertTrue(current == startValue + times, format("Counter value did not increase by %s. " +
                "Expected current > start, but got current=%s and start=%s, performed clicks=%s", times, current, startValue, times));
        softAssert.assertAll();
    }

}
