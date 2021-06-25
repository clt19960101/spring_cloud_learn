package com.springcloudalibaba.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName NacosPaymentController
 * @Author Chen Langtao
 * @Date 2021/6/25 22:34
 * @Description TODO
 * @Version 1.0
 */
@RestController
@Slf4j
public class NacosPaymentController {
    @Resource
    private RestTemplate restTemplate;


    @Value("${service-url.nacos-user-service}")
    private String serverUrl;


    @GetMapping(value = "/consumer/payment/nacos/{string}")
    public String echo(@PathVariable String string) {
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + string, String.class);

    }

}
