package com.su.springdataredisdemo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.su.springdataredisdemo2.mapper")
public class Springdataredisdemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springdataredisdemo2Application.class, args);
    }

}
