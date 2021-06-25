package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName OrderOpenFeignMainBoot80
 * @Author Chen Langtao
 * @Date 2021/6/25 11:30
 * @Description TODO
 * @Version 1.0
 */
@SpringBootApplication
//激活OpenFeign
@EnableFeignClients
@EnableEurekaClient
public class OrderOpenFeignMainBoot80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMainBoot80.class, args);
    }
}
