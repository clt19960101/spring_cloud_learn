package com.springcloud.demo.controller;

import com.springcloud.demo.entity.CommonResult;
import com.springcloud.demo.entity.Payment;
import com.springcloud.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PaymentController
 * @Author Chen Langtao
 * @Date 2021/6/22 20:49
 * @Description TODO
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    /**
     * 写操作用post
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            log.info("@数据库插入成功:" + result);
            return new CommonResult(200, "插入数据库成功", result);
        } else {
            log.info("@数据库插入失败");
            return new CommonResult(404, "插入数据库失败", null);
        }

    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            log.info("@查询成功:" + payment);
            return new CommonResult(200, "查询成功", payment);
        } else {
            log.info("@查询失败");
            return new CommonResult(404, "查询失败", null);
        }

    }

}
