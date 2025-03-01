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
 * 订单主启动类
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class OrderApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(OrderApplication.class,args);
        System.out.println("***********订单服务启动成功***********");
    }
}
