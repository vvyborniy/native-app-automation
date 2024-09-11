package com.aqa.mobile;

import com.aqa.mobile.common.BaseTest;
import com.aqa.mobile.driver.MobileDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @DataProvider
    private Object[][] searchDataProvider() {
        return new Object[][]{
                {"ap"},
                {"API"},
                {"api"},
                {"api demos"},
                {"demos"},
                {"demOS"},
                {"dem"},
                {"com."}
        };
    }

    @DataProvider
    private Object[][] searchNegativeDataProvider() {
        return new Object[][]{
                {"%$#"},
                {" "}
        };
    }

    @Test(description = "Test Case #1: Verify search of applications.", dataProvider = "searchDataProvider")
    public void testCase1(String text) {
        application.mainPage().assertPageIsLoaded();
        application.mainPage().clickOnAppTab();

        application.appMenuPage().assertPageIsLoaded();
        application.appMenuPage().clickOnLoaderTab();

        application.loaderMenuPage().assertPageIsLoaded();
        application.loaderMenuPage().clickOnCustomTab();

        application.customSearchPage().assertPageIsLoaded();
        application.customSearchPage().clickOnSearchIcon();
        application.customSearchPage().enterSearchText(text);
        MobileDriver.hideKeyboard();

        application.customSearchPage().verifySearchResultsByInput(text);
        application.customSearchPage().clearSearchInput();
        application.customSearchPage().verifyClearSearchField();
    }

    @Test(description = "Test Case #1 [Negative]: Verify search of applications.", dataProvider = "searchNegativeDataProvider")
    public void testCase1Negative(String text) {
        application.mainPage().assertPageIsLoaded();
        application.mainPage().clickOnAppTab();

        application.appMenuPage().assertPageIsLoaded();
        application.appMenuPage().clickOnLoaderTab();

        application.loaderMenuPage().assertPageIsLoaded();
        application.loaderMenuPage().clickOnCustomTab();

        application.customSearchPage().assertPageIsLoaded();
        application.customSearchPage().clickOnSearchIcon();
        application.customSearchPage().enterSearchText(text);
        MobileDriver.hideKeyboard();

        application.customSearchPage().verifyNoApplicationPlaceholderDisplayed();
    }

}
