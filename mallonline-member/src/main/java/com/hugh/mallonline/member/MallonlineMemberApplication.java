package com.hugh.mallonline.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.hugh.mallonline.member.dao")
@SpringBootApplication
public class MallonlineMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallonlineMemberApplication.class, args);
    }

}
