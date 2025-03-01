package com.su;

/**
 * Hello world!
 *
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 支付服务主启动类
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient//向注册中心注册该服务，并且可以获取其他服务的调用地址
public class PaymentApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(PaymentApplication.class,args);
        System.out.println("**************支付服务启动成功***************");
    }
}
