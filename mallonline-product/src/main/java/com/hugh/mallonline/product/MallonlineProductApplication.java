package com.hugh.mallonline.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.hugh.mallonline.product.feign")
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.hugh.mallonline.product.dao")
public class MallonlineProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallonlineProductApplication.class, args);
    }

}
