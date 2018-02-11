package com.lihy.serviceSecondImpl.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lihy
 * @date 2018/02/11
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages={"com.lihy.serviceSecondImpl"})
public class ServiceSecondImplApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSecondImplApplication.class, args);
    }
}
