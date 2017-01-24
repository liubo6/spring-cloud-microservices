package com.liubo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行注册服务
 */
@EnableEurekaServer
@SpringBootApplication
public class LiuboEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiuboEurekaApplication.class, args);
    }
}
