package com.hugh.mallonline.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.hugh.mallonline.order")
@SpringBootApplication
public class MallonlineOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallonlineOrderApplication.class, args);
    }

}
