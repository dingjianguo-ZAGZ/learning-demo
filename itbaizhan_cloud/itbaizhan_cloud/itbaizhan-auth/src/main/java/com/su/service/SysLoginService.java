package com.su.service;

import com.su.domain.LoginBodyDTO;
import com.su.domain.R;
import com.su.utils.JWTUtils;
import org.jose4j.lang.JoseException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
@Service
public class SysLoginService {
    public R login(LoginBodyDTO loginBodyDTO) throws JoseException {
        if(StringUtils.isEmpty(loginBodyDTO.getUsername())||StringUtils.isEmpty(loginBodyDTO.getPassword())){
            return R.fail("用户名或者密码为空");
        }
        //查询数据库操作
        if(loginBodyDTO.getUsername().equals("admin")&&loginBodyDTO.getPassword().equals("123456")){
            //返回令牌给客户端
            String token = JWTUtils.sign(1001L, "admin");
            return R.ok(token);
        }else {
            return R.fail("用户名或密码不正确");
        }

    }
}
