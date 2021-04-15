package com.unicorn.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * <p>
 *     全局统一异常处理类
 * </p>
 * Created on 2021/03/30 14:52
 *
 * @author Unicorn
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public void allExceptionHandler(){
        System.out.println("进入了异常处理方法!");
    }

}
