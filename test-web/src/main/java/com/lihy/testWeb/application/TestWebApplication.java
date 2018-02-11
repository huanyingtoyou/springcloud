package com.lihy.testWeb.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 * 注解ComponentScan扫描包名下的服务
 * 注解EnableFeignClients指明feign接口定义
 * @author lihy
 * @date 2018/02/08
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages={"com.lihy"})
@EnableFeignClients(basePackages = "com.lihy.feign.api")
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableZuulProxy
public class TestWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestWebApplication.class, args);
	}
}
