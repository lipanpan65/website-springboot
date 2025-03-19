package com.lipanpan.website.common;

import com.lipanpan.website.enums.ResultCodeEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void testEnum() {
        // 测试枚举值是否正确
        assertEquals("0000", ResultCodeEnum.SUCCESS.getCode());
        assertEquals("SUCCESS", ResultCodeEnum.SUCCESS.getMessage());
        assertEquals("9999", ResultCodeEnum.FAILURE.getCode());
        assertEquals("FAILURE", ResultCodeEnum.FAILURE.getMessage());
    }


    @Test
    void testSuccess() {
//        Result<String> result = Result.success("data");
        Result<String> result = Result.success();
        System.out.println(result);
    }


    @Test
    void testSuccessNoArgs() {
        // 测试无参的成功结果
        Result<String> result = Result.success();
        assertEquals(ResultCodeEnum.SUCCESS.getCode(), result.getCode());
        assertEquals(ResultCodeEnum.SUCCESS.getMessage(), result.getMessage());
        assertNull(result.getData()); // 断言 data 为 null
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
        System.out.println(result);
    }

    @Test
    void testSuccessWithData() {
        // 测试带数据的成功结果
        String data = "测试数据";
        Result<String> result = Result.success(data);
        assertTrue(result.isSuccess()); // 断言 success 为 true
        assertEquals(ResultCodeEnum.SUCCESS.getCode(), result.getCode());
        assertEquals(ResultCodeEnum.SUCCESS.getMessage(), result.getMessage());
        assertEquals(data, result.getData()); // 断言 data 正确
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
        System.out.println(result);
    }

    @Test
    void testSuccessWithMessageAndData() {
        // 测试带自定义消息和数据的成功结果
        String message = "自定义成功消息";
        String data = "测试数据";
        Result<String> result = Result.success(message, data);
        assertTrue(result.isSuccess()); // 断言 success 为 true
        assertEquals(ResultCodeEnum.SUCCESS.getCode(), result.getCode());
        assertEquals(message, result.getMessage()); // 断言自定义消息正确
        assertEquals(data, result.getData()); // 断言 data 正确
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
        System.out.println(result);
    }

    @Test
    void testFailureNoArgs() {
        // 测试无参的失败结果
        Result<Void> result = Result.failure();
        assertFalse(result.isSuccess()); // 断言 success 为 false
        assertEquals(ResultCodeEnum.FAILURE.getCode(), result.getCode());
        assertEquals(ResultCodeEnum.FAILURE.getMessage(), result.getMessage());
        assertNull(result.getData()); // 断言 data 为 null
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
        System.out.println(result);
    }

    @Test
    void testFailureWithMessage() {
        // 测试带自定义消息的失败结果
        String message = "自定义失败消息";
        Result<String> result = Result.failure(message);
        assertFalse(result.isSuccess()); // 断言 success 为 false
        assertEquals(ResultCodeEnum.FAILURE.getCode(), result.getCode());
        assertEquals(message, result.getMessage()); // 断言自定义消息正确
        assertNull(result.getData()); // 断言 data 为 null
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
        System.out.println(result);
    }

    @Test
    void testFailureWithCodeAndMessage() {
        // 测试带自定义状态码和消息的失败结果
        String code = "9998";
        String message = "自定义失败消息";
        Result<String> result = Result.failure(code, message);
        assertFalse(result.isSuccess()); // 断言 success 为 false
        assertEquals(code, result.getCode()); // 断言自定义状态码正确
        assertEquals(message, result.getMessage()); // 断言自定义消息正确
        assertNull(result.getData()); // 断言 data 为 null
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
        System.out.println(result);
    }

    @Test
    void testIsFailure() {
        // 测试 isFailure() 方法
        Result<String> successResult = Result.success();
        assertFalse(successResult.isFailure()); // 断言 successResult 不是失败

        Result<String> failureResult = Result.failure();
        assertTrue(failureResult.isFailure()); // 断言 failureResult 是失败
        System.out.println(failureResult);
    }
}