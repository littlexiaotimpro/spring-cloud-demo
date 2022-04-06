package com.spring.cloud.consumer.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    /**
     * 指定feign的日志输出级别
     *
     * @return FULL
     */
    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

}
