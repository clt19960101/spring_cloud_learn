package com.springcloud.demo.MyRoundRobinRule;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName MyRoundRobinRule
 * @Author Chen Langtao
 * @Date 2021/6/25 9:58
 * @Description 我的轮询算法
 * @Version 1.0
 */
public interface MyRoundRobinRule {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
