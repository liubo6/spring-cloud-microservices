package com.liubo.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hzlbo on 2017/2/13 0013.
 */
@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;

    //增加@HystrixCommand注解来指定回调方法
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://compute-service/add?a=10&b=20", String.class).getBody();
    }

    public String addServiceFallback() {
        return "error";
    }
}
