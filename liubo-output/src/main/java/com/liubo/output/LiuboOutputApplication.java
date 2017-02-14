package com.liubo.output;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LiuboOutputApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiuboOutputApplication.class, args);
    }
}
