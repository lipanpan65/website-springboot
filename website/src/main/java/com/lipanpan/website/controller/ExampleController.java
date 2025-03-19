package com.lipanpan.website.controller;

import com.lipanpan.website.common.Result;
import com.lipanpan.website.enums.ResultCodeEnum;
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
//         return Result.success();
//         return Result.success(message);
//         return Result.success(message);
        return Result.success(ResultCodeEnum.SUCCESS);
//        return Result.chainSuccess().message(message).build();
    }
}