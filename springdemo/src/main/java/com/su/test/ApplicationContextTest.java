package com.su.test;

import com.su.dao.UserDao;
import com.su.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextTest {

    public static void main(String[] args) throws Exception{

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.show();
    }
}
