package com.su.service;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "2.0.0")
public class PaymentServiceImpl implements IPaymentService{
    @Override
    public String payment(String id) {
        return "hello dubbo2.0.0";
    }
}
