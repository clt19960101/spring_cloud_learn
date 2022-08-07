package com.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Author Chen Langtao
 * @Date 2021/6/23 14:30
 * @Description TODO
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean

    //重写负载均衡轮询算法需要去掉@LoadBalanced注解
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
