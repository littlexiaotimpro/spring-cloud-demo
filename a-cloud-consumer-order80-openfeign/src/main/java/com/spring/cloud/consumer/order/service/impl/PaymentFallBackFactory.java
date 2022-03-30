package com.spring.cloud.consumer.order.service.impl;


import com.spring.cloud.common.api.dto.ResponseResult;
import com.spring.cloud.common.api.entity.Payment;
import com.spring.cloud.consumer.order.service.PaymentService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义feign回调工厂
 */
@Component
public class PaymentFallBackFactory implements FallbackFactory<PaymentService> {
    @Override
    public PaymentService create(Throwable cause) {
        cause.printStackTrace();
        return new PaymentService() {
            @Override
            public ResponseResult<Integer> create(Payment payment) {
                return ResponseResult.failed("服务故障，创建订单失败，请稍后重试！");
            }

            @Override
            public ResponseResult<Integer> deleteById(Long id) {
                return ResponseResult.failed("服务故障，删除订单失败，请稍后重试！");
            }

            @Override
            public ResponseResult<Integer> modifyPayment(Payment payment) {
                return ResponseResult.failed("服务故障，修改订单失败，请稍后重试！");
            }

            @Override
            public ResponseResult<Payment> findPaymentById(Long id) {
                return ResponseResult.failed("服务故障，查询数据失败，请稍后重试！");
            }

            @Override
            public ResponseResult<String> timeout() {
                return ResponseResult.failed("访问超时，请稍后重试！");
            }

            @Override
            public ResponseResult<String> redirectTo() {
                return ResponseResult.failed("服务故障，重定向失败，请稍后重试！");
            }
        };
    }
}
