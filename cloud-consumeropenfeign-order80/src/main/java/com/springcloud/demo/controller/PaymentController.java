package com.springcloud.demo.controller;

import com.springcloud.demo.Service.OpenFeignService;
import com.springcloud.demo.entity.CommonResult;
import com.springcloud.demo.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName PaymentController
 * @Author Chen Langtao
 * @Date 2021/6/25 12:59
 * @Description TODO
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private OpenFeignService openFeignService;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult create(@RequestParam("serial") String serial){
        Payment payment = new Payment();
        payment.setSerial(serial);
        log.info("payment"+payment);
        return openFeignService.create(payment);
    }


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        log.info("id"+id);
        return openFeignService.getPaymentById(id);
    }


    @GetMapping("/consumer/payment/balance")
    public String  balance() {
        return openFeignService.balance();

    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String  getTimeout() {
        return openFeignService.getTimeout();
    }

}
