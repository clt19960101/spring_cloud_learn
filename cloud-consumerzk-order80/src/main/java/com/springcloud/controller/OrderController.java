package com.springcloud.controller;

import com.springcloud.demo.entity.CommonResult;
import com.springcloud.demo.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Author Chen Langtao
 * @Date 2021/6/23 10:40
 * @Description TODO
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {
    // 只关注微服务实例名称
//      public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://cloud-provider-service";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/zk")
    public String zkOrder() {
        return restTemplate.getForObject(PAYMENT_URL + "/zkPayment/zkport", String.class);
    }

}
