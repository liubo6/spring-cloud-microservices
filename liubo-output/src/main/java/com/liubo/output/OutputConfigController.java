package com.liubo.output;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hzlbo on 2017/2/13 0013.
 */
@RefreshScope
@RestController
public class OutputConfigController {

    @Value("${url}")
    private String url;

    @RequestMapping("/get")
    public String getContent() {
        return this.url;
    }
}
