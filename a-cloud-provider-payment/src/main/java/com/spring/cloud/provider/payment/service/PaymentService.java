package com.spring.cloud.provider.payment.service;

import com.spring.cloud.common.api.entity.Payment;

public interface PaymentService {

    int create(Payment payment);

    int deleteById(Long id);

    int modifyPayment(Payment payment);

    Payment findPaymentById(Long id);

}
