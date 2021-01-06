package com.spring.cloud.common.api.dto;

/**
 * 响应结果状态码
 */
public enum ResponseCode {
    /**
     * 访问成功时的状态码
     */
    SUCCESS(1),

    /**
     * 访问失败时的状态码
     */
    FAILED(-1);

    private final int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
