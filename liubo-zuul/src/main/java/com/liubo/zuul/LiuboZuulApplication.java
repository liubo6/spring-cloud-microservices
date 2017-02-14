package com.liubo.zuul;

import com.liubo.zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 使用@EnableZuulProxy注解开启Zuul
 * 不仅仅实现了路由功能来屏蔽诸多服务细节，更实现了服务级别、均衡负载的路由。
 * 实现了接口权限校验与微服务业务逻辑的解耦。通过服务网关中的过滤器，在各生命周期中去校验请求的内容，
 * 将原本在对外服务层做的校验前移，保证了微服务的无状态性，同时降低了微服务的测试难度，让服务本身更集中关注业务逻辑的处理。
 * 实现了断路器，不会因为具体微服务的故障而导致服务网关的阻塞，依然可以对外服务
 */
@EnableZuulProxy
@SpringBootApplication
public class LiuboZuulApplication {


    public static void main(String[] args) {
        SpringApplication.run(LiuboZuulApplication.class, args);
    }

    //实例化该过滤器才能生效
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}