package com.lihy.registryCenter.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lihy
 * @date 2018/02/07
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaRegistryCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRegistryCenterApplication.class, args);
    }
}
