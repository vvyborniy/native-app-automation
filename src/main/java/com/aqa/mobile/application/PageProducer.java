package com.aqa.mobile.application;

import com.aqa.mobile.application.page.MainPage;
import com.aqa.mobile.application.page.preferences.*;
import com.aqa.mobile.application.popup.WiFiSettingsPopup;

public class PageProducer {

    private MainPage mainPage;
    private PreferencePage preferencePage;
    private PreferenceFromCodePage preferenceFromCodePage;
    private LaunchingPreferencesPage launchingPreferencesPage;
    private AdvancedPreferencesPage advancedPreferencesPage;
    private PreferenceDependenciesPage preferenceDependenciesPage;
    private WiFiSettingsPopup wiFiSettingsPopup;


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

    public PreferenceDependenciesPage initPreferenceDependenciesPage() {
        preferenceDependenciesPage = preferenceDependenciesPage != null ? preferenceDependenciesPage : new PreferenceDependenciesPage();
        return preferenceDependenciesPage;
    }

    public WiFiSettingsPopup initWiFiSettingsPopup() {
        wiFiSettingsPopup = wiFiSettingsPopup != null ? wiFiSettingsPopup : new WiFiSettingsPopup();
        return wiFiSettingsPopup;
    }
}
