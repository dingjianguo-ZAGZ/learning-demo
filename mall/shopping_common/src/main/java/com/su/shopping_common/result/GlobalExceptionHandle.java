package com.su.shopping_common.result;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(BusException.class)
    public BaseResult defaultExceptionHandle(BusException e){
        return new BaseResult(e.getCode(),e.getMsg(),null);
    }
    @ExceptionHandler(Exception.class)
    public BaseResult runTimeExceptionHandle(Exception e){
        e.printStackTrace();
        BaseResult baseResult = new BaseResult(CodeEnum.SYSTEM_ERROR.getCode(), CodeEnum.SYSTEM_ERROR.getMessage(), null);
        return baseResult;
    }
}
