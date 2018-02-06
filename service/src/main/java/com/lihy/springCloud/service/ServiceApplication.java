package com.lihy.springCloud.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihy
 * @date 2017/10/17
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceApplication {

    @GetMapping("/service")
    public String service() {
        return "service";
    }
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}
