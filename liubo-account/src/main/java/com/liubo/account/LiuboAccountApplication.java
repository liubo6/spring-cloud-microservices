package com.liubo.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @ServletComponentScan有此注解后，项目中如果需要使用java原生的servlet和filter，<br/>
 * 可以在类中使用注解实现，主要是配置Druid监控时需要用到
 */
@SpringBootApplication
@ServletComponentScan
public class LiuboAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiuboAccountApplication.class, args);
    }
}
