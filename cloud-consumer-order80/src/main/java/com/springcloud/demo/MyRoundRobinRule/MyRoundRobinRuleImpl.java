package com.springcloud.demo.MyRoundRobinRule;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyRoundRobinRuleImpl
 * @Author Chen Langtao
 * @Date 2021/6/25 10:00
 * @Description TODO
 * @Version 1.0
 */
@Component
public class MyRoundRobinRuleImpl implements MyRoundRobinRule {
    private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        //服务下标
        int index = incrementAndGet() % serviceInstances.size();
        return serviceInstances.get(index);
    }


    public final int incrementAndGet() {
        int current;
        int next;

        do {
            current = nextServerCyclicCounter.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!nextServerCyclicCounter.compareAndSet(current, next));
        System.out.println("@****************第几次访问：" + next);
        return next;
    }
}
