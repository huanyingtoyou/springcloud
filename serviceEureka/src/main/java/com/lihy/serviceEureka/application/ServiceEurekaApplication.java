package com.lihy.serviceEureka.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihy
 * @date 2018/02/06
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceEurekaApplication.class, args);
    }

    /**
     * 这是一种获取方式
     */
    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "你好，" + name + "，我来自端口号：" + port;
    }
}
