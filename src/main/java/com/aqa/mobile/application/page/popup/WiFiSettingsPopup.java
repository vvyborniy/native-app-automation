package com.aqa.mobile.application.page.popup;

import com.aqa.mobile.application.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static java.lang.String.format;

public class WiFiSettingsPopup extends BasePage {

    @AndroidFindBy(id = "android:id/parentPanel")
    private WebElement parentPanel;

    @AndroidFindBy(id = "android:id/edit")
    private WebElement inputField;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement okButton;

    @Step("Assert 'WiFiSettingsPopup' loaded")
    public void assertPopupIsLoaded() {
        Assert.assertTrue(parentPanel.isDisplayed(), "WiFiSettings Popup isn't load");
    }

    @Step("Click on OK button")
    public void clickOnOKButton() {
        okButton.click();
    }

    @Step("Enter text [{text}] to popup input field")
    public void enterTextToField(String text) {
        inputField.sendKeys(text);
    }

    @Step("Verify input field doesn’t display previously entered text [{text}]")
    public void verifyInputFieldWithout(String text) {
        Assert.assertNotEquals(inputField.getText(), text, format("Input field value equals to entered [%s], but shouldn't.", text));
    }

}
