package com.lipanpan.website.exception;

import com.lipanpan.website.enums.ResultCodeEnum;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final ResultCodeEnum resultCode;

    public BusinessException(ResultCodeEnum resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public BusinessException(ResultCodeEnum resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    // 静态方法：快速抛异常
    public static void throwByCode(ResultCodeEnum code) {
        throw new BusinessException(code);
    }

    public static void throwByMsg(String message) {
        throw new BusinessException(ResultCodeEnum.FAILURE, message);
    }
}