package com.su.controller;

import com.su.domain.LoginBodyDTO;
import com.su.domain.R;
import com.su.service.SysLoginService;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登陆控制类
 */
@RestController
public class LoginController {
    @Autowired
    private SysLoginService service;

    /**
     * 用户登录
     * @param loginBodyDTO 用户登录模型
     * @return
     */
    @PostMapping("/login")
    public R login(@RequestBody LoginBodyDTO loginBodyDTO) throws JoseException {
        System.out.println("授权");
        R login = service.login(loginBodyDTO);
        return login;
    }
}
