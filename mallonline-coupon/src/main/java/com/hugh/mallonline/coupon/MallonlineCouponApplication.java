package com.hugh.mallonline.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hugh.mallonline.coupon.dao")
@SpringBootApplication
public class MallonlineCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallonlineCouponApplication.class, args);
    }

}
