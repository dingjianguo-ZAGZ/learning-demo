package com.su.service.impl;

import com.su.dao.UserDao;
import com.su.service.UserService;
import org.springframework.beans.factory.InitializingBean;

public class UserServiceImpl implements UserService, InitializingBean {
    //提供set方法，beanFactory调用该方法，获得UserDao设置到此处
    public void setUserDao(UserDao userDao){
        System.out.println("属性设置完毕");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现afterPropertiesSet 方法执行");
    }
}
