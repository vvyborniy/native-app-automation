package com.aqa.mobile.application.page.animation;

import com.aqa.mobile.application.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class AnimationMenuPage extends BasePage {


    @AndroidFindBy(id = "android:id/list")
    private WebElement innerLayout;

    @AndroidFindBy(accessibility = "Seeking")
    private WebElement seekingTab;


    @Step("Assert 'AnimationMenuPage' loaded")
    public void assertPageIsLoaded() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(innerLayout.isDisplayed(), "AnimationMenuPage isn't load");
        softAssert.assertTrue(seekingTab.isDisplayed(), "AnimationMenuPage isn't load");
        softAssert.assertAll();
    }

    @Step("Go to 'Seeking Page'")
    public void clickOnSeekingTab() {
        seekingTab.click();
    }
}
