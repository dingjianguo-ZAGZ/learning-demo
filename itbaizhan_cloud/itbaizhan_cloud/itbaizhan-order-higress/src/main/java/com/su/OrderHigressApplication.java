package com.su;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 主启动类
 *
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class OrderHigressApplication{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderHigressApplication.class,args);
        System.out.println("*************订单服务启动***************");
    }
}

