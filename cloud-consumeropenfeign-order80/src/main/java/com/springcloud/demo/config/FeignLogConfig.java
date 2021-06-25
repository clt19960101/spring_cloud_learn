package com.springcloud.demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignLogConfig
 * @Author Chen Langtao
 * @Date 2021/6/25 15:43
 * @Description TODO
 * @Version 1.0
 */
@Configuration
public class FeignLogConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
