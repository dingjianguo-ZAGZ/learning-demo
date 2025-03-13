package com.su.service.impl;

import com.su.dao.UserDao;
import com.su.service.UserService;

public class UserServiceImpl implements UserService {
    //提供set方法，beanFactory调用该方法，获得UserDao设置到此处
    public void setUserDao(UserDao userDao){
        System.out.println("beanFactory调用该方法，获得UserDao"+userDao);
    }
}
