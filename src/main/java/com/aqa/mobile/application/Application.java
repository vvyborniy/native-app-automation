package com.aqa.mobile.application;

import com.aqa.mobile.application.page.MainPage;
import com.aqa.mobile.application.page.preferences.AdvancedPreferencesPage;
import com.aqa.mobile.application.page.preferences.LaunchingPreferencesPage;
import com.aqa.mobile.application.page.preferences.PreferenceFromCodePage;
import com.aqa.mobile.application.page.preferences.PreferencePage;

public class Application {

    private final PageProducer pageProducer = new PageProducer();


    public MainPage mainPage() {
        return pageProducer.initMainPage();
    }

    public PreferencePage preferencePage() {
        return pageProducer.initPreferencePage();
    }

    public PreferenceFromCodePage preferenceFromCodePage() {
        return pageProducer.initPreferenceFromCodePage();
    }

    public AdvancedPreferencesPage advancedPreferencesPage() {
        return pageProducer.initAdvancedPreferencesPage();
    }

    public LaunchingPreferencesPage launchingPreferencesPage() {
        return pageProducer.initLaunchingPreferencesPage();
    }
}
