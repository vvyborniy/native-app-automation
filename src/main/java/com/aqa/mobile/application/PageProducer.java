package com.aqa.mobile.application;

import com.aqa.mobile.application.page.MainPage;
import com.aqa.mobile.application.page.animation.AnimationMenuPage;
import com.aqa.mobile.application.page.animation.SeekingPage;
import com.aqa.mobile.application.page.app_menu.AppMenuPage;
import com.aqa.mobile.application.page.app_menu.CustomSearchPage;
import com.aqa.mobile.application.page.app_menu.LoaderMenuPage;
import com.aqa.mobile.application.page.popup.WiFiSettingsPopup;
import com.aqa.mobile.application.page.preferences.*;

public class PageProducer {

    private MainPage mainPage;
    private PreferenceMenuPage preferenceMenuPage;
    private PreferenceFromCodePage preferenceFromCodePage;
    private LaunchingPreferencesPage launchingPreferencesPage;
    private AdvancedPreferencesPage advancedPreferencesPage;
    private PreferenceDependenciesPage preferenceDependenciesPage;
    private WiFiSettingsPopup wiFiSettingsPopup;
    private AnimationMenuPage animationMenuPage;
    private SeekingPage seekingPage;
    private AppMenuPage appMenuPage;
    private CustomSearchPage customSearchPage;
    private LoaderMenuPage loaderMenuPage;


    public MainPage initMainPage() {
        mainPage = mainPage != null ? mainPage : new MainPage();
        return mainPage;
    }

    public PreferenceMenuPage initPreferencePage() {
        preferenceMenuPage = preferenceMenuPage != null ? preferenceMenuPage : new PreferenceMenuPage();
        return preferenceMenuPage;
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

    public AnimationMenuPage initAnimationMenuPage() {
        animationMenuPage = animationMenuPage != null ? animationMenuPage : new AnimationMenuPage();
        return animationMenuPage;
    }

    public SeekingPage initSeekingPage() {
        seekingPage = seekingPage != null ? seekingPage : new SeekingPage();
        return seekingPage;
    }

    public LoaderMenuPage initLoaderMenuPage() {
        loaderMenuPage = loaderMenuPage != null ? loaderMenuPage : new LoaderMenuPage();
        return loaderMenuPage;
    }

    public CustomSearchPage initCustomSearchPage() {
        customSearchPage = customSearchPage != null ? customSearchPage : new CustomSearchPage();
        return customSearchPage;
    }

    public AppMenuPage initAppMenuPage() {
        appMenuPage = appMenuPage != null ? appMenuPage : new AppMenuPage();
        return appMenuPage;
    }
}
