package com.eitraz.darksky;

public enum Units {
    US("us"),
    SI("si"),
    CA("ca"),
    UK("uk"),
    UK2("uk2"),
    AUTO("auto");

    private final String code;

    Units(String code) {
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
