package com.enumvalidate;

import java.util.Arrays;

public enum EnumTest {
    STANDARD_LOGIN("standard login"),
    DOMAIN_LOGIN("domain login");
    private final String value;

    EnumTest(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EnumTest fromString(String type) throws Exception {
        return Arrays.stream(EnumTest.values())
                .filter(loginType -> loginType.getValue().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new Exception (""));
    }
}
