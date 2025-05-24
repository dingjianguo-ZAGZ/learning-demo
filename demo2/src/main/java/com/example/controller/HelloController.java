package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/2221/5507")
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello 苏红润";
    }
}
