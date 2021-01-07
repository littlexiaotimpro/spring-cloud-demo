package com.spring.cloud.common.api.dto;

import java.io.Serializable;

/**
 * 响应结果传输实体
 *
 * @author XiaoSi
 */
public class ResponseResult<T> implements Serializable {

    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <K> ResponseResult<K> success(String message, K data) {
        ResponseResult<K> result = new ResponseResult<>();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <K> ResponseResult<K> failed(String message) {
        ResponseResult<K> result = new ResponseResult<>();
        result.setCode(ResponseCode.FAILED.getCode());
        result.setMessage(message);
        return result;
    }

    public static <K> ResponseResult<K> failed(int code, String message) {
        ResponseResult<K> result = new ResponseResult<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

}
