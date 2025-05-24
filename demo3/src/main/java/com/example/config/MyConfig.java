package com.example.config;

import com.example.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public StudentService studentService(){
        return new StudentService();
    }
}
