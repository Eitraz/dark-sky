package com.eitraz.darksky;

public enum Language {
    ARABIC("ar"),
    BOSNIAN("bs"),
    GERMAN("de"),
    GREEK("el"),
    ENGLISH("en"),
    SPANISH("es"),
    FRENCH("fr"),
    CROATIAN("hr"),
    ITALIAN("it"),
    DUTCH("nl"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    RUSSIAN("ru"),
    SLOVAK("sk"),
    SWEDISH("sv"),
    TETUM("tet"),
    TURKISH("tr"),
    UKRAINIAN("uk"),
    IGPAY_ATINLAY("x-pig-latin"),
    SIMPLIFIED_CHINESE("zh"),
    TRADITIONAL_CHINESE("or zh-tw");

    private final String code;

    Language(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return getCode();
    }
}
