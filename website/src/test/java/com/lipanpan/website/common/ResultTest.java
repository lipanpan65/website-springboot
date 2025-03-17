package com.lipanpan.website.common;

import com.lipanpan.website.enums.ResultCodeEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void testEnum() {
//        System.out.println(ResultCodeEnum.SUCCESS.getCode());
        System.out.println("sss");
    }

    @Test
    void testSuccessNoArgs() {
        Result<String> result = Result.success();
        assertTrue(result.getSuccess());
        assertFalse(result.getFailure());
        assertEquals(ResultCodeEnum.SUCCESS.getCode(), result.getCode());
        assertEquals(ResultCodeEnum.SUCCESS.getMessage(), result.getMessage());
        assertNull(result.getData());
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
    }

    @Test
    void testSuccessWithMessage() {
        String message = "自定义成功消息";
        Result<String> result = Result.success(message);
        assertTrue(result.getSuccess());
        assertFalse(result.getFailure());
        assertEquals(ResultCodeEnum.SUCCESS.getCode(), result.getCode());
        assertEquals(message, result.getMessage());
        assertNull(result.getData());
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
    }

    @Test
    void testSuccessWithData() {
        String data = "测试数据";
        Result<String> result = Result.success(data);
        assertTrue(result.getSuccess());
        assertFalse(result.getFailure());
        assertEquals(ResultCodeEnum.SUCCESS.getCode(), result.getCode());
        assertEquals(ResultCodeEnum.SUCCESS.getMessage(), result.getMessage());
        assertEquals(data, result.getData());
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
    }

    @Test
    void testSuccessWithMessageAndData() {
        String message = "自定义成功消息";
        String data = "测试数据";
        Result<String> result = Result.success(message, data);
        assertTrue(result.getSuccess());
        assertFalse(result.getFailure());
        assertEquals(ResultCodeEnum.SUCCESS.getCode(), result.getCode());
        assertEquals(message, result.getMessage());
        assertEquals(data, result.getData());
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
    }

    @Test
    void testSuccessWithCodeAndMessage() {
        String code = "0001";
        String message = "自定义成功消息";
        Result<String> result = Result.success(code, message);
        assertTrue(result.getSuccess());
        assertFalse(result.getFailure());
        assertEquals(code, result.getCode());
        assertEquals(message, result.getMessage());
        assertNull(result.getData());
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
    }

    @Test
    void testFailureNoArgs() {
        Result<String> result = Result.failure();
        assertFalse(result.getSuccess());
        assertTrue(result.getFailure());
        assertEquals(ResultCodeEnum.FAILURE.getCode(), result.getCode());
        assertEquals(ResultCodeEnum.FAILURE.getMessage(), result.getMessage());
        assertNull(result.getData());
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
    }

    @Test
    void testFailureWithMessage() {
        String message = "自定义失败消息";
        Result<String> result = Result.failure(message);
        assertFalse(result.getSuccess());
        assertTrue(result.getFailure());
        assertEquals(ResultCodeEnum.FAILURE.getCode(), result.getCode());
        assertEquals(message, result.getMessage());
        assertNull(result.getData());
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
    }

    @Test
    void testFailureWithData() {
        String data = "测试数据";
        Result<String> result = Result.failure(data);
        assertFalse(result.getSuccess());
        assertTrue(result.getFailure());
        assertEquals(ResultCodeEnum.FAILURE.getCode(), result.getCode());
        assertEquals(ResultCodeEnum.FAILURE.getMessage(), result.getMessage());
        assertEquals(data, result.getData());
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
    }

    @Test
    void testFailureWithMessageAndData() {
        String message = "自定义失败消息";
        String data = "测试数据";
        Result<String> result = Result.failure(message, data);
        assertFalse(result.getSuccess());
        assertTrue(result.getFailure());
        assertEquals(ResultCodeEnum.FAILURE.getCode(), result.getCode());
        assertEquals(message, result.getMessage());
        assertEquals(data, result.getData());
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
    }

    @Test
    void testFailureWithCodeAndMessage() {
        String code = "9998";
        String message = "自定义失败消息";
        Result<String> result = Result.failure(code, message);
        assertFalse(result.getSuccess());
        assertTrue(result.getFailure());
        assertEquals(code, result.getCode());
        assertEquals(message, result.getMessage());
        assertNull(result.getData());
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
    }

    @Test
    void testMessageMethod() {
        String message = "新消息";
        Result<String> result = Result.success().message(message);
//        Result<Object> result1 = Result.success(message);
        assertEquals(message, result.getMessage());
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
    }

    @Test
    void testCodeMethod() {
        String code = "0002";
        Result<String> result = Result.success().code(code);
        assertEquals(code, result.getCode());
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
    }

    @Test
    void testDataMethod() {
        String data = "新数据";
        Result<String> result = Result.success().data(data);
        assertEquals(data, result.getData());
        assertTrue(result.getTimestamp() > 0); // 验证时间戳是否正确设置
    }
}