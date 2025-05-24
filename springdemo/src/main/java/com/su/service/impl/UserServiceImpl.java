package com.su.service.impl;

import com.su.mapper.UserMapper;
import com.su.pojo.User;
import com.su.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void show(){
        List<User> userList = userMapper.findAll();
        userList.forEach(user -> System.out.println(user));
    }
}
