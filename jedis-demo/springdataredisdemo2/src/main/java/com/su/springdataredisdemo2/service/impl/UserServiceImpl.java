package com.su.springdataredisdemo2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.su.springdataredisdemo2.entity.User;
import com.su.springdataredisdemo2.service.UserService;
import com.su.springdataredisdemo2.mapper.UserMapper;

import com.google.common.cache.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
* @author suhon
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-09-24 08:44:42
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    private LoadingCache<String,User> loadingCache = CacheBuilder.newBuilder()
            //设置并发级别为16，并发级别是指可以同时写缓存的线程数
            .concurrencyLevel(16)
    //设置缓存容器的初始容量为1000
                .initialCapacity(1000)
    //设置缓存最大容量为10000，超过10000之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(10000)
    //设缓存1小时没被使用就过期
                .expireAfterAccess(1, TimeUnit.HOURS)
    //设置要统计缓存的命中率
                .recordStats()
                .build(new CacheLoader<String, User>() {
        @Override
        public User load(String key) throws Exception {
            //查询redis
            User user = (User) redisTemplate.opsForValue().get("user:" + key);
            if(user !=null){
                return user;
            }
            //查询数据库
            User u = userMapper.selectById(key);
            //放入缓存中
            redisTemplate.opsForValue().set("user:" + key,u);
            return u;
        }
    });
    @Override
    public User getById(Long id) throws ExecutionException {
        //从本地缓存中获取
        User user = loadingCache.get("user:" + id);
        return user;
    }

}




