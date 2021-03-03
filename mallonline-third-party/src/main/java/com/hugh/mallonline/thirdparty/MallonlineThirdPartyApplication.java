package com.hugh.mallonline.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MallonlineThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallonlineThirdPartyApplication.class, args);
    }

}
