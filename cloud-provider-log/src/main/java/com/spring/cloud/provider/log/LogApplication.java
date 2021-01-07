package com.spring.cloud.provider.log;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 日志服务启动类
 *
 * @author XiaoSi
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
public class LogApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(LogApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
