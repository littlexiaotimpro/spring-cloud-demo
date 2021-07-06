package com.spring.cloud.provider.payment.zk.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api("支付模块控制器")
@RestController
@RequestMapping(value = "/payment")
@Profile(value = {"service8003"})
@Slf4j
public class PaymentController8003 {

    @Value("${server.port}")
    private String serverPort;

    private final DiscoveryClient discoveryClient;

    public PaymentController8003(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @ApiOperation("随机序列号")
    @GetMapping(value = "/uuid")
    public Object zk_UUID() {
        log.info("Server.port: {}", serverPort);
        return "Server.port: " + serverPort + ", UUID: " + UUID.randomUUID();
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
