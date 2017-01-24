package com.liubo.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @EnableFeignClients注解开启Feign功能 可以在本地应用中像本地服务一下的调用它，并且做到了客户端均衡负载
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LiuboFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiuboFeignApplication.class, args);
    }
}
