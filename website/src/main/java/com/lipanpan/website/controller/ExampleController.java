package com.lipanpan.website.controller;

import com.lipanpan.website.common.Result;
import com.lipanpan.website.enums.ResultCodeEnum;
import com.lipanpan.website.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleController {

    @GetMapping("/hello")
    public Result<Object> hello(@RequestParam(required = false) String name) {
        if (name == null || name.isEmpty()) {
            return Result.failure(ResultCodeEnum.PARAM_IS_INVALID);
        }
        String message = "Hello, " + name + "!";
        return Result.success(ResultCodeEnum.SUCCESS, message);
    }

    @GetMapping("/user")
    public Result<String> getUser(@RequestParam Long id) {
        if (id == null) {
            // 直接抛异常（推荐）
            throw new BusinessException(ResultCodeEnum.PARAM_IS_INVALID, "用户ID不能为空");
        }
        // 或通过工具类封装（可选）
        if (id == 0L) {
            BusinessException.throwByCode(ResultCodeEnum.PARAM_IS_INVALID);
        }
        return Result.success("用户信息");
    }
}