package com.lipanpan.website.common;

import com.lipanpan.website.enums.ResultCodeEnum;
import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Result<T> implements Serializable {

    private final boolean success; // 是否成功
    private final String code;     // 状态码
    private final String message;  // 消息
    private final T data;          // 数据
    private final long timestamp;  // 时间戳

    // 判断是否失败
    public boolean isFailure() {
        return !success;
    }

    // 静态工厂方法：成功（带默认数据）
    public static <T> Result<T> success() {
        return success(ResultCodeEnum.SUCCESS, null);
    }

    // 静态工厂方法：成功（带数据）
    public static <T> Result<T> success(T data) {
        return success(ResultCodeEnum.SUCCESS, null, data);
    }

    // 静态工厂方法：成功（自定义消息 + 数据）
    public static <T> Result<T> success(String message, T data) {
        return success(ResultCodeEnum.SUCCESS, message, data);
    }

    // 静态工厂方法：成功（传入枚举 + 数据）
    public static <T> Result<T> success(ResultCodeEnum resultCode, T data) {
        return success(resultCode, null, data);
    }

    // 静态工厂方法：成功（传入枚举 + 自定义消息 + 数据）
    public static <T> Result<T> success(ResultCodeEnum resultCode, String message, T data) {
        return Result.<T>builder()
                .success(true)
                .code(resultCode.getCode())
                .message(message != null ? message : resultCode.getMessage())
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    // 静态工厂方法：失败（默认消息）
    public static <T> Result<T> failure() {
        return failure(ResultCodeEnum.FAILURE, null, null);
    }

    // 静态工厂方法：失败（自定义消息）
    public static <T> Result<T> failure(String message) {
        return failure(ResultCodeEnum.FAILURE, message, null);
    }

    // 静态工厂方法：失败（自定义状态码 + 消息）
    public static <T> Result<T> failure(String code, String message) {
        return Result.<T>builder()
                .success(false)
                .code(code)
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    // 静态工厂方法：失败（仅传入枚举）
    public static <T> Result<T> failure(ResultCodeEnum resultCode) {
        return failure(resultCode, null, null);
    }

    // 静态工厂方法：失败（传入枚举 + 自定义消息）
    public static <T> Result<T> failure(ResultCodeEnum resultCode, String message) {
        return failure(resultCode, message, null);
    }

    // 静态工厂方法：失败（传入枚举 + 数据）
    public static <T> Result<T> failure(ResultCodeEnum resultCode, T data) {
        return failure(resultCode, null, data);
    }

    // 静态工厂方法：失败（传入枚举 + 自定义消息 + 数据）
    public static <T> Result<T> failure(ResultCodeEnum resultCode, String message, T data) {
        return Result.<T>builder()
                .success(false)
                .code(resultCode.getCode())
                .message(message != null ? message : resultCode.getMessage())
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    // 静态工厂方法：链式调用入口（成功）
    public static <T> ResultBuilder<T> chainSuccess() {
        return Result.<T>builder()
                .success(true)
                .code(ResultCodeEnum.SUCCESS.getCode())
                .message(ResultCodeEnum.SUCCESS.getMessage())
                .timestamp(System.currentTimeMillis());
    }

    // 静态工厂方法：链式调用入口（失败）
    public static <T> ResultBuilder<T> chainFailure() {
        return Result.<T>builder()
                .success(false)
                .code(ResultCodeEnum.FAILURE.getCode())
                .message(ResultCodeEnum.FAILURE.getMessage())
                .timestamp(System.currentTimeMillis());
    }

    // 静态内部类：支持链式调用的 ResultBuilder
    public static class ResultBuilder<T> {
        private boolean success;
        private String code;
        private String message;
        private T data;
        private long timestamp;

        // 链式调用：设置消息
        public ResultBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        // 链式调用：设置数据
        public ResultBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        // 链式调用：设置状态码
        public ResultBuilder<T> code(String code) {
            this.code = code;
            return this;
        }

        // 链式调用：设置时间戳
        public ResultBuilder<T> timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        // 构建 Result 对象
        public Result<T> build() {
            return new Result<>(success, code, message, data, timestamp);
        }
    }
}