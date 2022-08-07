package com.springcloud.demo.controller;

import com.springcloud.demo.MyRoundRobinRule.MyRoundRobinRule;
import com.springcloud.demo.entity.CommonResult;
import com.springcloud.demo.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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
    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private MyRoundRobinRule myRoundRobinRule;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("@payment:" + payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id) {
        log.info("@id:" + id);
        //getForObject() 返回对象为响应体中数据转换的对象，可以理解为Json
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }


    @GetMapping("/consumer/getForEntity/{id}")
    public CommonResult<Payment> getForEntity(@PathVariable("id") Long id) {
        log.info("@id:" + id);

        //getForEntity() 返回对象为ResponseEntity对象，包含了响应中的一些重要信息，如响应头，响应状态码，响应体等
        ResponseEntity<CommonResult> templateForEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (templateForEntity.getStatusCode().is2xxSuccessful()) {
            return templateForEntity.getBody();
        } else {
            return new CommonResult<>( 444, "操作失败");
        }
    }


    /**
     * 重写轮询负载均衡算法
     */
    @GetMapping("/consumer/getLoadBalance")
    public String getLoadBalance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        ServiceInstance serviceInstance = myRoundRobinRule.instances(instances);
        URI uri = serviceInstance.getUri();
        log.info("RUI:"+uri);
        return restTemplate.getForObject(uri + "/payment/balance", String.class);
    }


}
