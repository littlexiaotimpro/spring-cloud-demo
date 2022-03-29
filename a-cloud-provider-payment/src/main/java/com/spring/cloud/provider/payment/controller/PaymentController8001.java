package com.spring.cloud.provider.payment.controller;

import com.spring.cloud.common.api.dto.ResponseResult;
import com.spring.cloud.common.api.entity.Payment;
import com.spring.cloud.provider.payment.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Api("支付模块控制器")
@RestController
@RequestMapping(value = "/payment")
@Profile(value = {"service8001"})
@Slf4j
public class PaymentController8001 {

    @Value("${server.port}")
    private String serverPort;

    private final PaymentService paymentService;

    private final DiscoveryClient discoveryClient;

    public PaymentController8001(PaymentService paymentService, DiscoveryClient discoveryClient) {
        this.paymentService = paymentService;
        this.discoveryClient = discoveryClient;
    }

    @ApiOperation("新增支付信息")
    @PostMapping(value = "/create")
    public ResponseResult<Integer> create(@RequestBody Payment payment) {
        log.info("ServerPort: {}", serverPort);
        int res = paymentService.create(payment);
        if (res > 0) {
            log.info("插入数据成功，返回结果：{}", res);
            return ResponseResult.success("Server: " + serverPort + "，新增成功", res);
        }
        log.info("插入数据失败！");
        return ResponseResult.failed("Server: " + serverPort + "，新增失败！");
    }

    @ApiOperation("通过主键删除支付信息")
    @PostMapping(value = "/delete/{id}")
    public ResponseResult<Integer> deleteById(@PathVariable("id") Long id) {
        log.info("ServerPort: {}", serverPort);
        int res = paymentService.deleteById(id);
        if (res > 0) {
            log.info("删除数据成功，id: {}", id);
            return ResponseResult.success("Server: " + serverPort + "，删除成功", res);
        }
        log.info("删除数据失败，id: {}", id);
        return ResponseResult.failed("Server: " + serverPort + "，删除失败！");
    }

    @ApiOperation("修改支付信息")
    @PostMapping(value = "/modify")
    public ResponseResult<Integer> modifyPayment(@RequestBody Payment payment) {
        log.info("ServerPort: {}", serverPort);
        int res = paymentService.modifyPayment(payment);
        if (res > 0) {
            log.info("修改数据成功，数据体: {}", payment);
            return ResponseResult.success("Server: " + serverPort + "，修改成功", res);
        }
        log.info("修改数据失败!");
        return ResponseResult.failed("Server: " + serverPort + "，修改失败！");
    }

    @ApiOperation("通过主键获取支付信息")
    @GetMapping(value = "/find/{id}")
    public ResponseResult<Payment> findPaymentById(@PathVariable("id") Long id) {
        log.info("ServerPort: {}", serverPort);
        Payment payment = paymentService.findPaymentById(id);
        if (Objects.nonNull(payment)) {
            log.info("查询数据成功，返回结果：{}", payment.toString());
            return ResponseResult.success("Server: " + serverPort + "，查询成功", payment);
        }
        log.info("查询数据失败！");
        return ResponseResult.failed("Server: " + serverPort + "，未找到对应数据，【id: " + id + "】！");
    }

    @ApiOperation("超时")
    @GetMapping(value = "/timeout")
    public ResponseResult<String> timeout() {
        log.info("ServerPort: {}", serverPort);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResponseResult.failed("Server: " + serverPort + "，服务访问超时！");
    }

    @ApiOperation("服务发现")
    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****** element: {}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t"
                    + instance.getHost() + "\t"
                    + instance.getPort() + "\t"
                    + instance.getUri());
        }
        return this.discoveryClient;
    }
}
