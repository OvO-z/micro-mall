package com.micro.mall.common.exception;

import com.micro.mall.common.api.CommonResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 * @author QAQ
 * @date 2021/5/16
 */

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 参数验证异常处理
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResult handleValidException(BindException e) {
        List<String> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error ->error.getField() + " : " + error.getDefaultMessage()).collect(Collectors.toList());
        return CommonResult.validateFailed(errors);
    }
}
