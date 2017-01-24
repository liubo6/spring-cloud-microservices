package com.liubo.calculate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @EnableDiscoveryClient注解，该注解能激活Eureka中的DiscoveryClient实现， 才能实现Controller中对服务信息的输出
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LiuboCalculateApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiuboCalculateApplication.class, args);
    }
}
