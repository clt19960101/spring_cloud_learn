package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaServerMianBoot
 * @Author Chen Langtao
 * @Date 2021/6/23 19:31
 * @Description TODO
 * @Version 1.0
 */
@SpringBootApplication
//表明这个是Eureka服务注册中心
@EnableEurekaServer
public class EurekaServerMainBoot {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMainBoot.class, args);
    }
}
