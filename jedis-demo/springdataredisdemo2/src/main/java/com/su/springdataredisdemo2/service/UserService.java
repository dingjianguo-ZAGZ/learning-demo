package com.su.springdataredisdemo2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.su.springdataredisdemo2.entity.User;

import java.util.concurrent.ExecutionException;

/**
* @author suhon
* @description 针对表【user】的数据库操作Service
* @createDate 2024-09-24 08:44:42
*/
public interface UserService extends IService<User> {
    User getById(Long id) throws ExecutionException;
}
