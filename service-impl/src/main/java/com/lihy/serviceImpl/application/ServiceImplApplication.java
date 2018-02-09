package com.lihy.serviceImpl.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 具体业务实现启动类
 * 相当于服务提供端provider
 * 注解ComponentScan扫描包名下的服务
 * @author lihy
 * @date 2018/02/08
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages={"com.lihy.serviceImpl"})
public class ServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceImplApplication.class, args);
    }
}
