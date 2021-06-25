package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName providerConsulMainBoot
 * @Author Chen Langtao
 * @Date 2021/6/24 15:57
 * @Description TODO
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulMainBoot {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulMainBoot.class, args);
    }
}
