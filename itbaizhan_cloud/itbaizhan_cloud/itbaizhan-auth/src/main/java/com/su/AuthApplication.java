package com.su;

import lombok.extern.slf4j.Slf4j;
import org.jose4j.lang.JoseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AuthApplication
{
    public static void main( String[] args ) throws JoseException {
        SpringApplication.run(AuthApplication.class,args);
        log.info("*****************  认证授权中心启动成功 **************");
    }
}
