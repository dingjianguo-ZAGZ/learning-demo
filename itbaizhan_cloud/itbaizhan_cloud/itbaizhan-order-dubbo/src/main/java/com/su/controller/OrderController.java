package com.su.controller;

import com.su.service.IPaymentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @DubboReference(version = "1.0.0")
    private IPaymentService iPaymentService;
    @GetMapping("/getPayment")
    public String payment(){
        return iPaymentService.payment("1");
    }
}
