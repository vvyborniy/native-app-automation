package com.aqa.mobile.application.page;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.aqa.mobile.driver.MobileDriver.getAppiumDriver;

public abstract class BasePage {


    protected BasePage() {
        PageFactory.initElements(
                new AppiumFieldDecorator(getAppiumDriver(), AppiumFieldDecorator.DEFAULT_WAITING_TIMEOUT), this);
    }


    public boolean isElementChecked(WebElement element) {
        return element.getAttribute("checked").equals("true");
    }


    @Step("Navigate back")
    public void navigateBackHardware() {
        getAppiumDriver().navigate().back();
    }
}
