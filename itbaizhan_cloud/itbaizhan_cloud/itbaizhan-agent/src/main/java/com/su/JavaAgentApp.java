package com.su;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ]主启动类
 *
 */
@SpringBootApplication
@Slf4j
public class JavaAgentApp

{
    public static void main( String[] args )
    {
        SpringApplication.run(JavaAgentApp.class,args);
        log.info("************success****************");
    }
}
