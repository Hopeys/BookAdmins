package com.ysq.obooks.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice
public class GlobalExceptionReturn {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handlerException(Exception e){

        return ApiRestResponse.error(BookAdminExceptionEnum.SYSTEM_ERROR);
    }
    @ExceptionHandler(BookAdminException.class)
    @ResponseBody
    public Object myException(BookAdminException ex){
        return ApiRestResponse.error(ex.getCode(),ex.getMessage());
    }

}
