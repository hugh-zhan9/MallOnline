package com.hugh.mallonline.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.hugh.mallonline.ware.dao")
@SpringBootApplication
public class MallonlineWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallonlineWareApplication.class, args);
    }

}
