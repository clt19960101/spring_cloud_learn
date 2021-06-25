package com.springcloud.demo.Service;

import com.springcloud.demo.entity.CommonResult;
import com.springcloud.demo.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName OpenFeignService
 * @Author Chen Langtao
 * @Date 2021/6/25 12:54
 * @Description TODO
 * @Version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
public interface OpenFeignService {
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment);


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);


    @GetMapping("/payment/balance")
    public String balance();

    @GetMapping("/payment/feign/timeout")
    public String getTimeout();
}
