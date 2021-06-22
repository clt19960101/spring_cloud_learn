package com.springcloud.demo.service.iml;

import com.springcloud.demo.dao.PaymentDao;
import com.springcloud.demo.entity.Payment;
import com.springcloud.demo.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PaymentServiceImpl
 * @Author Chen Langtao
 * @Date 2021/6/22 20:42
 * @Description TODO
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
