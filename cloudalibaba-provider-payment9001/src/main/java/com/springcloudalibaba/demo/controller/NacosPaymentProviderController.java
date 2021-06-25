package com.springcloudalibaba.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName NacosPaymentProviderController
 * @Author Chen Langtao
 * @Date 2021/6/25 20:42
 * @Description TODO
 * @Version 1.0
 */
@RestController
@Slf4j
public class NacosPaymentProviderController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string + "serverPort:" + serverPort;
    }
}
