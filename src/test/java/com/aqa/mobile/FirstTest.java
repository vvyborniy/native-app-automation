package com.aqa.mobile;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class FirstTest extends BaseTest {


    @Test(description = "Test Case #2: Verify checkboxes and switches on 'Preference From Code' page")
    public void testCase2() {
        mainPage.assertMainPageLoaded();
        mainPage.clickOnPreferenceTab();

        preferencePage.assertPreferencePageLoaded();
        preferencePage.clickOnPreferenceFromCodeTab();

        preferenceFromCodePage.assertPreferenceFromCodePageLoaded();
        preferenceFromCodePage.checkAllCheckboxes();
        preferenceFromCodePage.verifyCheckedAllCheckboxes();
        preferenceFromCodePage.checkAllSwitchWidgets();
        preferenceFromCodePage.verifyCheckedAllSwitchWidgets();
    }
}
