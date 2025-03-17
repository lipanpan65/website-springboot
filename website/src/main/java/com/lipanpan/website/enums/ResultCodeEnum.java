package com.lipanpan.website.enums;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    /**
     * 操作失败
     */
    FAILURE("9999", "FAILURE"),

    /**
     * 参数错误 1001-1999
     */
    PARAM_IS_INVALID("1001", "参数无效"),
    PARAM_TYPE_ERROR("1002", "参数类型错误"),

    /**
     * 服务异常
     */
    SERVER_ERROR("5000", "服务器内部错误"),

    /**
     * 操作成功
     */
    SUCCESS("0000", "SUCCESS");

    // 手动添加 getter 方法
    private final String code;
    private final String message;

    // 手动添加构造器
    ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}