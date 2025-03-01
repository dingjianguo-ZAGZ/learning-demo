package com.su.shopping_manager_api.security;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.security.access.AccessDeniedException;

@RestControllerAdvice
public class AccessDeniedExceptionHandler {
    //处理权限不足时，捕获到异常再次抛出，交给AccessDeniedExceptionHandler处理
    @ExceptionHandler(AccessDeniedException.class)
    public void defaultExceptionHandler(AccessDeniedException e) throws AccessDeniedException{
        throw e;
    }
}
