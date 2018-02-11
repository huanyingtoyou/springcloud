package com.lihy.zuul.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * 单独的一个路由测试
 * test-web中集成的也有路由
 * @author lihy
 * @date 2018/02/11
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@ComponentScan("com.lihy.zuul")
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
