package com.su.springdataredisdemo2;

import com.su.springdataredisdemo2.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Springdataredisdemo2ApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Test
    void contextLoads() {
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setUsername("su");
        user.setAge(18);
        redisTemplate.opsForValue().set("user",user);


    }

}
