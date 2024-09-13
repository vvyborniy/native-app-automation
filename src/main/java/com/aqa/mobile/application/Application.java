package com.aqa.mobile.application;

import com.aqa.mobile.application.page.MainPage;
import com.aqa.mobile.application.page.animation.AnimationMenuPage;
import com.aqa.mobile.application.page.animation.SeekingPage;
import com.aqa.mobile.application.page.app_menu.AppMenuPage;
import com.aqa.mobile.application.page.app_menu.CustomSearchPage;
import com.aqa.mobile.application.page.app_menu.LoaderMenuPage;
import com.aqa.mobile.application.page.popup.WiFiSettingsPopup;
import com.aqa.mobile.application.page.preferences.*;

public class Application {

    private final PageProducer pageProducer = new PageProducer();


    public MainPage mainPage() {
        return pageProducer.initMainPage();
    }

    public PreferenceMenuPage preferencePage() {
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

    public PreferenceDependenciesPage preferenceDependenciesPage() {
        return pageProducer.initPreferenceDependenciesPage();
    }

    public WiFiSettingsPopup wiFiSettingsPopup() {
        return pageProducer.initWiFiSettingsPopup();
    }

    public AnimationMenuPage animationMenuPage() {
        return pageProducer.initAnimationMenuPage();
    }

    public SeekingPage seekingPage() {
        return pageProducer.initSeekingPage();
    }

    public AppMenuPage appMenuPage() {
        return pageProducer.initAppMenuPage();
    }

    public CustomSearchPage customSearchPage() {
        return pageProducer.initCustomSearchPage();
    }

    public LoaderMenuPage loaderMenuPage() {
        return pageProducer.initLoaderMenuPage();
    }
}
