package com.su.springdataesdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
public class SpringdataesdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdataesdemoApplication.class, args);
    }

}
