package com.aqa.mobile.common;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum KeyPhraseState {

    CLICKABLE("clickable", true),
    NOT_CLICKABLE("not clickable", false),
    ENABLE("enable", true),
    NOT_ENABLE("not enable", false);

    private final String phrase;
    private final boolean state;

    public boolean isTrue() {
        return state;
    }

    @Override
    public String toString() {
        return phrase;
    }
}
