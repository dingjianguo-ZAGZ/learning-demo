package com.su.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * 订单控制器
 */
@RestController
public class OrderController {
    @GetMapping("/index")
    public String index(){
        System.out.println("higress");
        return "hello higress";
    }
}
