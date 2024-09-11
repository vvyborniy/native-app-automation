package com.aqa.mobile.application;

import com.aqa.mobile.application.page.MainPage;
import com.aqa.mobile.application.page.preferences.AdvancedPreferencesPage;
import com.aqa.mobile.application.page.preferences.LaunchingPreferencesPage;
import com.aqa.mobile.application.page.preferences.PreferenceFromCodePage;
import com.aqa.mobile.application.page.preferences.PreferencePage;

public class PageProducer {

    private MainPage mainPage;
    private PreferencePage preferencePage;
    private PreferenceFromCodePage preferenceFromCodePage;
    private LaunchingPreferencesPage launchingPreferencesPage;
    private AdvancedPreferencesPage advancedPreferencesPage;


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

    public LaunchingPreferencesPage initLaunchingPreferencesPage() {
        launchingPreferencesPage = launchingPreferencesPage != null ? launchingPreferencesPage : new LaunchingPreferencesPage();
        return launchingPreferencesPage;
    }

    public AdvancedPreferencesPage initAdvancedPreferencesPage() {
        advancedPreferencesPage = advancedPreferencesPage != null ? advancedPreferencesPage : new AdvancedPreferencesPage();
        return advancedPreferencesPage;
    }
}
