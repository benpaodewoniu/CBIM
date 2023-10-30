package com.cbim.cbim.enums;

public enum ServiceEnums {
    USER("1"),
    SCORE("2");
    private final String code;

    ServiceEnums(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
