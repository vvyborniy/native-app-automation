package com.aqa.mobile;

import com.aqa.mobile.common.BaseTest;
import com.aqa.mobile.common.helper.RandomHelper;
import com.aqa.mobile.driver.MobileDriver;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.aqa.mobile.common.KeyPhraseState.*;

@Log4j2
public class PreferencesTest extends BaseTest {


    //TODO Test in multithreading
    @BeforeMethod(description = "Precondition: Go to 'Preference' from Main page")
    private void goToPreferenceFromMainPage() {
        application.mainPage().assertPageIsLoaded();
        application.mainPage().clickOnPreferenceTab();

        application.preferencePage().assertPageIsLoaded();
    }

    @Test(description = "Test Case #2: Verify checkboxes and switches on 'Preference From Code' page", groups = "smoke")
    public void testCase2() {
        application.preferencePage().clickOnPreferenceFromCodeTab();
        application.preferenceFromCodePage().assertPageIsLoaded();

        application.preferenceFromCodePage().enableAllCheckboxes();
        application.preferenceFromCodePage().verifyCheckedAllCheckboxes();
        application.preferenceFromCodePage().enableAllSwitchWidgets();
        application.preferenceFromCodePage().verifyCheckedAllSwitchWidgets();
    }


    @Test(description = "Test Case #3: Verify counter increase by click on 'Launching preferences' and 'Advanced Preferences' pages", groups = "smoke")
    public void testCase3() {
        application.preferencePage().clickOnLaunchingPreferencesTab();
        application.launchingPreferencesPage().assertPageIsLoaded();

        int startCounterValueLaunching = application.launchingPreferencesPage().getCounterValue();
        application.launchingPreferencesPage().clickOnLaunchPreferenceActivityButton();

        application.advancedPreferencesPage().assertPageIsLoaded();
        int startCounterValueAdvanced = application.advancedPreferencesPage().getCounterValue();
        int times = RandomHelper.randomInt(1, 10);
        application.advancedPreferencesPage().clickOnMyPreferenceWidget(times);

        application.advancedPreferencesPage().verifyIncreaseCounterBy(times, startCounterValueAdvanced);
        application.advancedPreferencesPage().navigateBackHardware();

        application.launchingPreferencesPage().assertPageIsLoaded();
        application.launchingPreferencesPage().verifyIncreaseCounterBy(times, startCounterValueLaunching);
    }

    @Test(description = "Test Case #4: Verify WiFi Settings", groups = "smoke")
    public void testCase4() {
        application.preferencePage().clickOnPreferenceDependenciesTab();
        application.preferenceDependenciesPage().assertPageIsLoaded();

        application.preferenceDependenciesPage().verifyWifiSettingsTabIsClickable(NOT_CLICKABLE);
        application.preferenceDependenciesPage().clickOnWifiCheckbox();
        application.preferenceDependenciesPage().verifyWifiCheckboxEnable(ENABLE);
        application.preferenceDependenciesPage().verifyWifiSettingsTabIsClickable(CLICKABLE);
        application.preferenceDependenciesPage().clickOnWifiSettingsTab();

        application.wiFiSettingsPopup().assertPopupIsLoaded();
        String text = RandomHelper.randomString();
        application.wiFiSettingsPopup().enterTextToField(text);
        application.wiFiSettingsPopup().clickOnOKButton();
        application.preferenceDependenciesPage().assertPageIsLoaded();
        MobileDriver.restartApp();

        this.goToPreferenceFromMainPage();
        application.preferencePage().clickOnPreferenceDependenciesTab();

        application.preferenceDependenciesPage().assertPageIsLoaded();
        application.preferenceDependenciesPage().verifyWifiCheckboxEnable(ENABLE);
        application.preferenceDependenciesPage().clickOnWifiSettingsTab();

        application.wiFiSettingsPopup().assertPopupIsLoaded();
        application.wiFiSettingsPopup().verifyInputFieldWithout(text);

    }
}
