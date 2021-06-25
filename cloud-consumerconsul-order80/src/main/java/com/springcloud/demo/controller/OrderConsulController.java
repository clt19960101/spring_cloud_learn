package com.springcloud.demo.controller;

import com.springcloud.demo.entity.CommonResult;
import com.springcloud.demo.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderConsulController
 * @Author Chen Langtao
 * @Date 2021/6/24 16:36
 * @Description TODO
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderConsulController {
    // 只关注微服务实例名称
    public static final String PAYMENT_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/consul")
    public Object paymentConsul() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul",String.class);
    }

}
