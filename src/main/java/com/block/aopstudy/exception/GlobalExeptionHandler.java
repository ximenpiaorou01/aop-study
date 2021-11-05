package com.block.aopstudy.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author wangrongsong
 * @title: GlobalException
 * @projectName aop-study
 * @description: TODO
 * @date 2021/11/6 12:16 上午
 */
@ControllerAdvice
@Slf4j
public class GlobalExeptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public String handlerException(Exception e){
        log.error("未知异常，原因是：",e);
        return e.getMessage();
    }
}
