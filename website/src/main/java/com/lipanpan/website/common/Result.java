package com.lipanpan.website.common;

import com.lipanpan.website.enums.ResultCodeEnum;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private Boolean failure;
    private Boolean success;
    private String code;
    private String message;
    private T data;
    private long timestamp;

    public Result() {
        this.timestamp = System.currentTimeMillis();
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public Result(String code, String message, T data) {
        this(code, message);
        this.data = data;
    }

    private void setTimestamp() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> Result<T> success() {
        System.out.println("success");
        Result<T> result = new Result<>();

        result.setSuccess(true);
        result.setFailure(false);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        result.setTimestamp();
        return result;
    }

    public static <T> Result<T> success(ResultCodeEnum resultCodeEnum) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setFailure(false);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        result.setTimestamp();
        return result;
    }

    public static <T> Result<T> success(String message) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setFailure(false);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(message);
        result.setTimestamp();
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setFailure(false);
        String code = ResultCodeEnum.SUCCESS.getCode();
        String message = ResultCodeEnum.SUCCESS.getMessage();
        System.out.println("Code: " + code);
        System.out.println("Message: " + message);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        result.setData(data);
        result.setTimestamp();
        return result;
    }

    public static <T> Result<T> success(String message, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setFailure(false);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(message);
        result.setData(data);
        result.setTimestamp();
        return result;
    }

    public static <T> Result<T> success(String code, String message) {
        Result<T> result = new Result<>();

        result.setSuccess(true);
        result.setFailure(false);
        result.setCode(code);
        result.setMessage(message);
        result.setTimestamp();
        return result;
    }

    public static <T> Result<T> success(String code, String message, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setFailure(false);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        result.setTimestamp();
        return result;
    }

    public static <T> Result<T> failure() {
        return failure(ResultCodeEnum.FAILURE);
    }

    public static <T> Result<T> failure(ResultCodeEnum resultCodeEnum) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setFailure(true);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        result.setTimestamp();
        return result;
    }

    public static <T> Result<T> failure(String message) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setFailure(true);
        result.setCode(ResultCodeEnum.FAILURE.getCode());
        result.setMessage(message);
        result.setTimestamp();
        return result;
    }

    public static <T> Result<T> failure(T data) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setFailure(true);
        result.setCode(ResultCodeEnum.FAILURE.getCode());
        result.setMessage(ResultCodeEnum.FAILURE.getMessage());
        result.setData(data);
        result.setTimestamp();
        return result;
    }

    public static <T> Result<T> failure(String message, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setFailure(true);
        result.setCode(ResultCodeEnum.FAILURE.getCode());
        result.setMessage(message);
        result.setData(data);
        result.setTimestamp();
        return result;
    }

    public static <T> Result<T> failure(String code, String message) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setFailure(true);
        result.setCode(code);
        result.setMessage(message);
        result.setTimestamp();
        return result;
    }

    public static <T> Result<T> failure(String code, String message, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setFailure(true);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        result.setTimestamp();
        return result;
    }

    public Result<T> message(String message) {
        this.message = message;
        return this;
    }

    public Result<T> code(String code) {
        this.code = code;
        return this;
    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }

//    public long getTimestamp() {
//        return timestamp;
//    }

    // 辅助方法，帮助泛型推断
    public static <T> Result<T> ofType(Class<T> type) {
        return success();
    }
}





