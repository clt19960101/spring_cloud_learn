package com.springcloud.demo.controller;

import com.springcloud.demo.entity.CommonResult;
import com.springcloud.demo.entity.Payment;
import com.springcloud.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentController
 * @Author Chen Langtao
 * @Date 2021/6/22 20:49
 * @Description TODO
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 注册进eureka里面的微服务,可以通过服务发现来获得该服务的信息
     */
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 写操作用post
     *
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("@payment:" + payment);
        int result = paymentService.create(payment);
        if (result > 0) {
            log.info("@数据库插入成功:" + result);
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, result);
        } else {
            log.info("@数据库插入失败");
            return new CommonResult(404, "插入数据库失败", null);
        }

    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            log.info("@查询成功啦啦啦啦:" + payment);
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, payment);
        } else {
            log.info("@查询失败");
            return new CommonResult(404, "查询失败", null);
        }

    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        //得到服务清单列表
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:", service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("ServiceId:" + instance.getServiceId(), "Host:" + instance.getHost(), "Port" + instance.getPort(), "Uri" + instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/payment/balance")
    public String balance() {
        return serverPort;

    }

    /**
     * feign 超时测试
     * @return
     */
    @GetMapping("/payment/feign/timeout")
    public String  getTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;

    }
}
