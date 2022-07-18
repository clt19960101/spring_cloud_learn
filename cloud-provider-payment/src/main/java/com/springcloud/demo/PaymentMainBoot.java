package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName PaymentMainBoot
 * @Author Chen Langtao
 * @Date 2021/6/20 12:32
 * @Description TODO
 * @Version 1.0
 */
@SpringBootApplication
//@EnableEurekaClient
//@EnableDiscoveryClient
public class PaymentMainBoot {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainBoot.class, args);
    }

}
