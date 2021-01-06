package com.spring.cloud.common.api.entity;

/**
 * 性别
 */
public enum Gender {
    MALE(1, "男"),
    FEMALE(0, "女");

    private final int code;
    private final String value;

    Gender(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
