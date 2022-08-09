package com.springcloud.myribbonrule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyRule
 * @Author Chen Langtao
 * @Date 2021/6/24 22:11
 * @Description 因为需要定制，所以不能放在主启动类下
 * @Version 1.0
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        //默认轮询，定义为随机
        return new RandomRule();
//        return new RoundRobinRule();
    }

}
