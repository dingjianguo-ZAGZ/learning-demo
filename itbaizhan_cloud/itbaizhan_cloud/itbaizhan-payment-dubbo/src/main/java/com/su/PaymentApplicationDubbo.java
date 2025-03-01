package com.su;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类
 *
 */
@SpringBootApplication
@Slf4j
@EnableDubbo
public class PaymentApplicationDubbo
{
    public static void main( String[] args )
    {
        SpringApplication.run(PaymentApplicationDubbo.class,args);
        System.out.println("*************支付服务启动***************");
    }
}
