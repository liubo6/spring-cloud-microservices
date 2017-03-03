package com.liubo.feign;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hzlbo on 2017/2/13 0013.
 */
@Service
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }

    @Override
    public Integer getA(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return null;
    }
}
