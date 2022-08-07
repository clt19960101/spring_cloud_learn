package com.springcloud.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * @ClassName PamentContorller
 * @Description TODO
 * @Author Langtao
 * @Date 2022/7/30 10:26
 * @Version V1.0
 */

@RestController
@RequestMapping("/zkPayment")
public class PamentContorller {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zkport")
    public String zkPayment() {
        return "zookeeper" + serverPort + "uuid:" + UUID.randomUUID();
    }

}
