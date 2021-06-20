package com.spring.cloud.consumer.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderAutoConfiguration {

    /**
     * {@link LoadBalanced @LoadBalanced} 负载均衡
     *
     * @return restful 接口调用模板
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
