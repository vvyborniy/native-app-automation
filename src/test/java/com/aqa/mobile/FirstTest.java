package com.aqa.mobile;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class FirstTest extends BaseTest {


    @Test
    public void testCase2() {
        mainPage.assertMainPageLoaded();
        mainPage.clickOnPreferenceTab();

        preferencePage.assertPreferencePageLoaded();
        preferencePage.clickOnPreferenceFromCodeTab();

        preferenceFromCodePage.assertPreferencePageLoaded();
        preferenceFromCodePage.checkAllCheckboxes();
        preferenceFromCodePage.verifyCheckedAllCheckboxes();
        preferenceFromCodePage.checkAllSwitchWidgets();
        preferenceFromCodePage.verifyCheckedAllSwitchWidgets();
    }
}
