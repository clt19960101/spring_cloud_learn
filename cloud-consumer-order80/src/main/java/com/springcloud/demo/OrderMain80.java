package com.springcloud.demo;

import com.springcloud.myribbonrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName OrderMain80
 * @Author Chen Langtao
 * @Date 2021/6/23 10:31
 * @Description TODO
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
//name为需要访问的服务名
//因为自定义RoundRobinRule,因此需要注释
//@RibbonClient(name = "CLOUD-PROVIDER-SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }

}
