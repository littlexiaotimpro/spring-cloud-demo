package com.spring.cloud.consumer.order.controller;

import com.spring.cloud.common.api.dto.ResponseResult;
import com.spring.cloud.common.api.entity.Payment;
import com.spring.cloud.common.api.utils.ParameterizedTypeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@Api("订单模块控制器")
@RestController
@RequestMapping(value = "/consumer")
@Slf4j
public class OrderController {

    @Value("${service-url.cloud-payment-service}")
    private String PAYMENT_URL;

    private final RestTemplate restTemplate;

    private final DiscoveryClient discoveryClient;

    public OrderController(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    @ApiOperation("新增订单")
    @GetMapping(value = "/payment/create")
    public ResponseResult<Integer> create(Payment payment) {
        Type type = ParameterizedTypeUtil.forType(ResponseResult.class, Integer.class);
        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment);
        ResponseEntity<ResponseResult<Integer>> responseEntity = restTemplate.exchange(PAYMENT_URL + "/create",
                HttpMethod.POST, httpEntity, ParameterizedTypeReference.forType(type));
        return responseEntity.getBody();
    }

    @ApiOperation("删除订单")
    @GetMapping(value = "/payment/delete/{id}")
    public ResponseResult<Integer> deleteById(@PathVariable Long id) {
        Type type = ParameterizedTypeUtil.forType(ResponseResult.class, Integer.class);
        ResponseEntity<ResponseResult<Integer>> responseEntity = restTemplate.exchange(PAYMENT_URL + "/delete/{id}",
                HttpMethod.POST, null, ParameterizedTypeReference.forType(type), id);
        return responseEntity.getBody();
    }

    @ApiOperation("修改订单")
    @GetMapping(value = "/payment/modify")
    public ResponseResult<Integer> modifyPayment(Payment payment) {
        Type type = ParameterizedTypeUtil.forType(ResponseResult.class, Integer.class);
        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment);
        ResponseEntity<ResponseResult<Integer>> responseEntity = restTemplate.exchange(PAYMENT_URL + "/modify",
                HttpMethod.POST, httpEntity, ParameterizedTypeReference.forType(type));
        return responseEntity.getBody();
    }

    @ApiOperation("查询订单")
    @GetMapping(value = "/payment/find/{id}")
    public ResponseResult<Payment> findPaymentById(@PathVariable Long id) {
        Type type = ParameterizedTypeUtil.forType(ResponseResult.class, Payment.class);
        ResponseEntity<ResponseResult<Payment>> responseEntity = restTemplate.exchange(PAYMENT_URL + "/find/{id}",
                HttpMethod.GET, null, ParameterizedTypeReference.forType(type), id);
        return responseEntity.getBody();
    }

    @ApiOperation("超时测试")
    @GetMapping(value = "/payment/timeout")
    public ResponseResult<String> timeout() {
        Type type = ParameterizedTypeUtil.forType(ResponseResult.class, String.class);
        ResponseEntity<ResponseResult<String>> responseEntity = restTemplate.exchange(PAYMENT_URL + "/timeout",
                HttpMethod.GET, null, ParameterizedTypeReference.forType(type));
        return responseEntity.getBody();
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
