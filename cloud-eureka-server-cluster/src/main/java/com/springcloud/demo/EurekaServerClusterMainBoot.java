package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaServerClusterMainBoot
 * @Author Chen Langtao
 * @Date 2021/6/23 22:43
 * @Description TODO
 * @Version 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerClusterMainBoot {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerClusterMainBoot.class, args);
    }
}
