package com.aqa.mobile.application.page.preferences;

import com.aqa.mobile.application.page.BasePage;
import com.aqa.mobile.common.KeyPhraseState;
import com.aqa.mobile.common.device.DeviceManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.aqa.mobile.common.KeyPhraseState.*;
import static java.lang.String.format;

public class PreferenceDependenciesPage extends BasePage {


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference/3. Preference dependencies']")
    private WebElement title;

    @AndroidFindBy(xpath = "//*[@text='WiFi settings']/ancestor::android.widget.LinearLayout[1]")
    private WebElement wifiSettingsTab;

    @AndroidFindBy(id = "android:id/checkbox")
    private WebElement wifiCheckbox;


    @Step("Assert 'PreferenceDependencies Page' loaded")
    public void assertPageIsLoaded() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isElementDisplayed(title), "PreferenceDependencies Page isn't load");
        softAssert.assertTrue(isElementDisplayed(wifiSettingsTab), "PreferenceDependencies Page isn't load");
        softAssert.assertTrue(isElementDisplayed(wifiCheckbox), "PreferenceDependencies Page isn't load");
        softAssert.assertAll();
    }

    @Step("Verify Wifi Setting tab is {isClickable}")
    public void verifyWifiSettingsTabIsClickable(KeyPhraseState isClickable) {
        //handling diff behavior on diff Android version
        if (DeviceManager.getLocalDevice().getPlatformVersion().equals("13")) {
            if (!isClickable.isTrue()) {
                this.clickOnWifiSettingsTab();
                this.assertPageIsLoaded();
            }
        } else {
            Assert.assertEquals(this.isWifiSettingsTabClickable(), isClickable.isTrue(),
                    format("Wifi settings tab attribute is %s. Expected: %s.",
                            isClickable.isTrue() ? NOT_CLICKABLE : CLICKABLE, isClickable));
        }
    }

    public boolean isWifiSettingsTabClickable() {
        return isElementClickable(wifiSettingsTab);
    }

    @Step("Click on Wifi Checkbox")
    public void clickOnWifiCheckbox() {
        wifiCheckbox.click();
    }

    @Step("Verify Wifi Checkbox is {isEnable}")
    public void verifyWifiCheckboxEnable(KeyPhraseState isEnable) {
        Assert.assertEquals(isElementChecked(wifiCheckbox), isEnable.isTrue(),
                format("Wifi Checkbox is %s. Expected: %s.",
                        isEnable.isTrue() ? ENABLE : NOT_ENABLE, isEnable));
    }

    @Step("Go to menu 'WiFi settings'")
    public void clickOnWifiSettingsTab() {
        wifiSettingsTab.click();
    }


}
