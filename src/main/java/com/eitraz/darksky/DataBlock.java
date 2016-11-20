package com.eitraz.darksky;

public enum DataBlock {
    CURRENTLY("currently"),
    MINUTELY("minutely"),
    HOURLY("hourly"),
    DAILY("daily"),
    ALERTS("alerts"),
    FLAGS("flags");

    private final String code;

    DataBlock(String code) {
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
