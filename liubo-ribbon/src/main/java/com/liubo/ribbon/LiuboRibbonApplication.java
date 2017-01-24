package com.liubo.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient注解来添加发现服务能力
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LiuboRibbonApplication {

    /**
     * 创建RestTemplate实例，并通过@LoadBalanced注解开启均衡负载能力
     *
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(LiuboRibbonApplication.class, args);
    }
}
