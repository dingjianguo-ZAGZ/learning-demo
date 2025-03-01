package com.su.springdataredisdemo2.controller;

import com.su.springdataredisdemo2.entity.User;
import com.su.springdataredisdemo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     *线程组 ：1000 吞吐量：998
     * 线程组 ：2000 吞吐量：1000.5
     * 线程组 ：10000 吞吐量：4541.5
     * 加入缓存
     *
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public User getById(Long id){

        return u;
    }
}
