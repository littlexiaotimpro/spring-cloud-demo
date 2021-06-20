package com.spring.cloud.provider.payment.dao;

import com.spring.cloud.common.api.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    int create(Payment payment);

    int deleteById(@Param("id") Long id);

    int modifyPayment(Payment payment);

    Payment findPaymentById(@Param("id") Long id);

}
