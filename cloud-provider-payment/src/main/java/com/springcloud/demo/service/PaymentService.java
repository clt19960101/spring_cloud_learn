package com.springcloud.demo.service;

import com.springcloud.demo.entity.Payment;

/**
 * @ClassName PaymentService
 * @Author Chen Langtao
 * @Date 2021/6/22 20:41
 * @Description TODO
 * @Version 1.0
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
