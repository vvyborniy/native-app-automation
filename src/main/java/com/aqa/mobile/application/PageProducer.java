package com.aqa.mobile.application;

import com.aqa.mobile.application.page.MainPage;
import com.aqa.mobile.application.page.PreferenceFromCodePage;
import com.aqa.mobile.application.page.PreferencePage;

public class PageProducer {

    private MainPage mainPage;
    private PreferencePage preferencePage;
    private PreferenceFromCodePage preferenceFromCodePage;


    public MainPage initMainPage() {
        mainPage = mainPage != null ? mainPage : new MainPage();
        return mainPage;
    }

    public PreferencePage initPreferencePage() {
        preferencePage = preferencePage != null ? preferencePage : new PreferencePage();
        return preferencePage;
    }

    public PreferenceFromCodePage initPreferenceFromCodePage() {
        preferenceFromCodePage = preferenceFromCodePage != null ? preferenceFromCodePage : new PreferenceFromCodePage();
        return preferenceFromCodePage;
    }
}
