package com.liubo.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hzlbo on 2017/1/24 0024.\
 * 使用@FeignClient("compute-service")注解来绑定该接口对应compute-service服务
 * <p>
 * fallback添加熔断器实现类
 */
@FeignClient(value = "compute-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    @RequestMapping(method = RequestMethod.GET, value = "/order/add")
    Integer getA(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
