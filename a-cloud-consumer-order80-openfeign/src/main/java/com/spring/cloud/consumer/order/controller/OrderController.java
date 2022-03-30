package com.spring.cloud.consumer.order.controller;

import com.spring.cloud.common.api.dto.ResponseResult;
import com.spring.cloud.common.api.entity.Payment;
import com.spring.cloud.consumer.order.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("订单模块控制器")
@RestController
@RequestMapping(value = "/consumer")
@Slf4j
public class OrderController {

    private final PaymentService paymentService;
    private final DiscoveryClient discoveryClient;

    public OrderController(PaymentService paymentService, DiscoveryClient discoveryClient) {
        this.paymentService = paymentService;
        this.discoveryClient = discoveryClient;
    }

    @ApiOperation("新增订单")
    @GetMapping(value = "/payment/create")
    public ResponseResult<Integer> create(Payment payment) {
        return paymentService.create(payment);
    }

    @ApiOperation("删除订单")
    @GetMapping(value = "/payment/delete/{id}")
    public ResponseResult<Integer> deleteById(@PathVariable Long id) {
        return paymentService.deleteById(id);
    }

    @ApiOperation("修改订单")
    @GetMapping(value = "/payment/modify")
    public ResponseResult<Integer> modifyPayment(Payment payment) {
        return paymentService.modifyPayment(payment);
    }

    @ApiOperation("查询订单")
    @GetMapping(value = "/payment/find/{id}")
    public ResponseResult<Payment> findPaymentById(@PathVariable Long id) {
        return paymentService.findPaymentById(id);
    }

    @ApiOperation("超时测试")
    @GetMapping(value = "/payment/timeout")
    public ResponseResult<String> timeout() {
        return paymentService.timeout();
    }

    @ApiOperation("重定向")
    @GetMapping(value = "/payment/redirect")
    public ResponseResult<String> redirect() {
        return paymentService.redirectTo();
    }

    @ApiOperation("服务发现")
    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****** element: {}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-ORDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t"
                    + instance.getHost() + "\t"
                    + instance.getPort() + "\t"
                    + instance.getUri());
        }
        return this.discoveryClient;
    }
}
