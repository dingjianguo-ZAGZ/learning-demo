package com.su.shopping_manager_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class ShoppingManagerApiApplicationTests {
    @Autowired
    PasswordEncoder encoder;
    @Test
    void contextLoads() {
        String baizhan = encoder.encode("baizhan");
        System.out.println(baizhan);
    }

}
