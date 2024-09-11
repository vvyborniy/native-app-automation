package com.aqa.mobile.application.page.app_menu;

import com.aqa.mobile.application.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.apache.logging.log4j.util.Strings;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class CustomSearchPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App/Loader/Custom']")
    private WebElement title;

    @AndroidFindBy(id = "android:id/list")
    private WebElement innerLayout;

    @AndroidFindBy(accessibility = "Search")
    private WebElement searchIcon;

    @AndroidFindBy(id = "android:id/search_src_text")
    private WebElement searchTextInput;

    @AndroidFindBy(id = "android:id/search_close_btn")
    private WebElement clearSearchInputButton;

    @AndroidFindBy(id = "io.appium.android.apis:id/text")
    private List<WebElement> listTextResults;

    @AndroidFindBy(id = "android:id/internalEmpty")
    private WebElement noApplicationPlaceholder;

    @Step("Assert 'CustomSearch page' loaded")
    public void assertPageIsLoaded() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(title.isDisplayed(), "CustomSearchPage isn't load");
        softAssert.assertTrue(innerLayout.isDisplayed(), "CustomSearchPage isn't load");
        softAssert.assertTrue(searchIcon.isDisplayed(), "CustomSearchPage isn't load");
        softAssert.assertAll();
    }

    @Step("Click on Search icon")
    public void clickOnSearchIcon() {
        searchIcon.click();
    }

    @Step("Enter search text [{text}] to search field")
    public void enterSearchText(String text) {
        searchTextInput.sendKeys(text);
    }

    @Step("Clear search input by click on 'X' button")
    public void clearSearchInput() {
        clearSearchInputButton.click();
    }

    @Step("Verify clear Search field")
    public void verifyClearSearchField() {
        Assert.assertTrue(Strings.isBlank(searchTextInput.getText()), "Search field isn't clear.");
    }

    @Step("Verify 'No Application' placeholder")
    public void verifyNoApplicationPlaceholderDisplayed() {
        Assert.assertTrue(noApplicationPlaceholder.isDisplayed(), "Placeholder isn't displayed.");
    }

    @Step("Verify search results by input [{searchText}]")
    public void verifySearchResultsByInput(String searchText) {
        Assert.assertFalse(listTextResults.isEmpty(), "Search results is empty.");
        Pattern pattern = Pattern.compile("(?i)\\b" + Pattern.quote(searchText) + "\\w*\\b");
        SoftAssert softAssert = new SoftAssert();
        List<String> searchResults = new ArrayList<>();
        for (int i = 0; i < listTextResults.size(); i++) {
            searchResults.add(listTextResults.get(i).getText());
        }
        boolean isAllMatchSearchText = searchResults.stream().allMatch(res -> pattern.matcher(res).find());
        softAssert.assertTrue(isAllMatchSearchText,
                format("Not all search results is correctly filtered. Search text was [%s]. Results is [%s].",
                        searchText, searchResults));

        List<String> alphabeticSorted = searchResults.stream().sorted(String::compareTo).collect(Collectors.toList());
        softAssert.assertEquals(searchResults, alphabeticSorted,
                format("Alphabetic order violated. Search text was [%s].", searchText));

        softAssert.assertAll();
    }


}
