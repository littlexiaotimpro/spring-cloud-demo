package com.spring.cloud.consumer.order.service;

import com.spring.cloud.common.api.dto.ResponseResult;
import com.spring.cloud.common.api.entity.Payment;
import com.spring.cloud.consumer.order.service.impl.PaymentFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 配置FeignClient服务接口，指定的服务为网关
 */
@FeignClient(value = "${feign.serviceId}", fallbackFactory = PaymentFallBackFactory.class)
public interface PaymentService {

    @PostMapping(value = "/create")
    ResponseResult<Integer> create(@RequestBody Payment payment);

    @PostMapping(value = "/delete/{id}")
    ResponseResult<Integer> deleteById(@PathVariable("id") Long id);

    @PostMapping(value = "/modify")
    ResponseResult<Integer> modifyPayment(@RequestBody Payment payment);

    @GetMapping(value = "/find/{id}")
    ResponseResult<Payment> findPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/timeout")
    ResponseResult<String> timeout();

    @GetMapping(value = "/redirect")
    ResponseResult<String> redirectTo();

}
