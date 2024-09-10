package com.aqa.mobile;

import com.aqa.mobile.common.BaseTest;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class FirstTest extends BaseTest {


    @Test(description = "Test Case #2: Verify checkboxes and switches on 'Preference From Code' page")
    public void testCase2() {
        application.mainPage().assertMainPageLoaded();
        application.mainPage().clickOnPreferenceTab();

        application.preferencePage().assertPreferencePageLoaded();
        application.preferencePage().clickOnPreferenceFromCodeTab();

        application.preferenceFromCodePage().assertPreferenceFromCodePageLoaded();
        application.preferenceFromCodePage().checkAllCheckboxes();
        application.preferenceFromCodePage().verifyCheckedAllCheckboxes();
        application.preferenceFromCodePage().checkAllSwitchWidgets();
        application.preferenceFromCodePage().verifyCheckedAllSwitchWidgets();
    }
}
