package com.aqa.mobile;

import com.aqa.mobile.common.BaseTest;
import org.testng.annotations.Test;

public class AnimationTest extends BaseTest {


    @Test(description = "Test Case #5: Verify ball change position.", groups = "regression")
    public void testCase5() {
        application.mainPage().assertPageIsLoaded();
        application.mainPage().clickOnAnimationTab();

        application.animationMenuPage().assertPageIsLoaded();
        application.animationMenuPage().clickOnSeekingTab();
        application.seekingPage().assertPageIsLoaded();
        application.seekingPage().moveSeekBarPointerAndAssertChangedBallLocation();
    }
}
