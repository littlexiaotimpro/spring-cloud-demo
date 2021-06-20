package com.spring.cloud.provider.payment.service.impl;

import com.spring.cloud.common.api.entity.Payment;
import com.spring.cloud.provider.payment.dao.PaymentDao;
import com.spring.cloud.provider.payment.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public int deleteById(Long id) {
        return paymentDao.deleteById(id);
    }

    @Override
    public int modifyPayment(Payment payment) {
        return paymentDao.modifyPayment(payment);
    }

    @Override
    public Payment findPaymentById(Long id) {
        return paymentDao.findPaymentById(id);
    }
}
