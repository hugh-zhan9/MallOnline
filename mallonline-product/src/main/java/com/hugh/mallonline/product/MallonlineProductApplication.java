package com.hugh.mallonline.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hugh.mallonline.product.dao")
public class MallonlineProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallonlineProductApplication.class, args);
    }

}
