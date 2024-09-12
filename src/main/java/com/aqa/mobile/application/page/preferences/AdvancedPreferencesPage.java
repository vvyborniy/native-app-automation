package com.aqa.mobile.application.page.preferences;

import com.aqa.mobile.application.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static java.lang.String.format;

public class AdvancedPreferencesPage extends BasePage {


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference/6. Advanced preferences']")
    private WebElement title;

    @AndroidFindBy(id = "io.appium.android.apis:id/mypreference_widget")
    private WebElement myPreferenceWidget;


    @Step("Assert 'AdvancedPreferencesPage' loaded")
    public void assertPageIsLoaded() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(title.isDisplayed(), "AdvancedPreferencesPage isn't load");
        softAssert.assertTrue(myPreferenceWidget.isDisplayed(), "AdvancedPreferencesPage isn't load");
        softAssert.assertAll();
    }

    @Step("Click on MyPreferenceWidget {times} times")
    public void clickOnMyPreferenceWidget(int times) {
        for (int i = 0; i < times; i++) {
            this.clickOnMyPreferenceWidget();
        }
    }

    @Step("Click on MyPreferenceWidget")
    public void clickOnMyPreferenceWidget() {
        myPreferenceWidget.click();
    }

    @SneakyThrows
    @Step("Verify counter increase by {times}.")
    public void verifyIncreaseCounterBy(int times, int startValue) {
        Thread.sleep(500); //sleep for counter update
        int current = this.getCounterValue();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(current, startValue, format("Counter doesn't change value on click." +
                "Expected current != initial value, " +
                "current_Counter_value=%s , performed clicks=%s, Initial_counter_value=%s", current, startValue, times));
        softAssert.assertTrue(current > startValue, format("Counter value did not increase on click. " +
                "Expected current > initial, but got Current_Counter_value=%s , performed clicks=%s, Initial_counter_value=%s", current, startValue, times));
        softAssert.assertTrue(current == startValue + times, format("Counter value did not increase by %s. " +
                "Current_Counter_value=%s , performed clicks=%s, Initial_counter_value=%s", times, current, startValue, times));
        softAssert.assertAll();
    }

    public int getCounterValue() {
        return Integer.parseInt(myPreferenceWidget.getText());
    }


}
