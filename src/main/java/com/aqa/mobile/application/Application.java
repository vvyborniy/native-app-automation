package com.aqa.mobile.application;

import com.aqa.mobile.application.page.MainPage;
import com.aqa.mobile.application.page.PreferenceFromCodePage;
import com.aqa.mobile.application.page.PreferencePage;

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
}
