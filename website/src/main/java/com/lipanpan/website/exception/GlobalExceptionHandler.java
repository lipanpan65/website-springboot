// 包路径改为 website.exception
package com.lipanpan.website.exception;

import com.lipanpan.website.common.Result;
import com.lipanpan.website.enums.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@Slf4j
@ControllerAdvice   // 无需指定包，默认扫描所有控制器
public class GlobalExceptionHandler {

    // ====================== 业务异常处理 ======================
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)  // 业务异常用 200 状态码，但标记为失败
    @ResponseBody
    public Result<?> handleBusinessException(BusinessException e) {
        log.error("业务异常: {}", e.getMessage(), e);
        return Result.failure(e.getResultCode(), e.getMessage());
    }

    // ====================== 参数校验异常处理 ======================
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result<?> handleValidationException(MethodArgumentNotValidException e) {
        String message = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        log.error("参数校验失败: {}", message);
        return Result.failure(ResultCodeEnum.PARAM_IS_INVALID, message);
    }

    // ====================== 全局异常处理（兜底） ======================
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result<?> handleGlobalException(Exception e) {
        log.error("全局异常: {}", e.getMessage(), e); // 记录堆栈信息
        return Result.failure(ResultCodeEnum.SERVER_ERROR, "服务器内部错误，请联系管理员");
    }
}