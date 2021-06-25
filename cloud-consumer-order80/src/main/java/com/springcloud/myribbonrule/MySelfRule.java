package com.springcloud.myribbonrule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyRule
 * @Author Chen Langtao
 * @Date 2021/6/24 22:11
 * @Description TODO
 * @Version 1.0
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        //默认轮询，定义为随机
        return new RandomRule();
    }

}
