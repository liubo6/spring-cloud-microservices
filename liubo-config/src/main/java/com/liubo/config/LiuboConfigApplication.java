package com.liubo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class LiuboConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiuboConfigApplication.class, args);
    }
}
