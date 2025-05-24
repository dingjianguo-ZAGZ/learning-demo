package com.su.service.impl;

import com.su.dao.UserDao;
import com.su.service.UserService;
import org.springframework.beans.factory.InitializingBean;

public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
        System.out.println("实例化UserServiceImpl对象，无参构造方法执行");
    }
    public UserServiceImpl(String name) {
        System.out.println("实例化UserServiceImpl对象，有参构造方法执行");
    }
    //提供set方法，beanFactory调用该方法，获得UserDao设置到此处
    public void setUserDao(UserDao userDao){
        System.out.println("属性设置完毕");
    }

}
