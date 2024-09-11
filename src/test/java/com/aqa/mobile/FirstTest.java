package com.aqa.mobile;

import com.aqa.mobile.common.BaseTest;
import com.aqa.mobile.common.helper.RandomHelper;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class FirstTest extends BaseTest {


    @Test(description = "Test Case #2: Verify checkboxes and switches on 'Preference From Code' page")
    public void testCase2() {
        application.mainPage().assertPageIsLoaded();
        application.mainPage().clickOnPreferenceTab();

        application.preferencePage().assertPageIsLoaded();
        application.preferencePage().clickOnPreferenceFromCodeTab();

        application.preferenceFromCodePage().assertPageIsLoaded();

        application.preferenceFromCodePage().enableAllCheckboxes();
        application.preferenceFromCodePage().verifyCheckedAllCheckboxes();
        application.preferenceFromCodePage().enableAllSwitchWidgets();
        application.preferenceFromCodePage().verifyCheckedAllSwitchWidgets();
    }

    @Test(description = "Test Case #3: Verify counter increase by click on 'Launching preferences' and 'Advanced Preferences' pages")
    public void testCase3() {
        application.mainPage().assertPageIsLoaded();
        application.mainPage().clickOnPreferenceTab();

        application.preferencePage().assertPageIsLoaded();
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
}
