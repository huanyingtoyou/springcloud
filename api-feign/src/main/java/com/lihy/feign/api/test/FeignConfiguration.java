package com.lihy.feign.api.test;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 暂时不用
 * @author lihy
 * @date 2018/02/09
 */
@Configuration
public class FeignConfiguration {
    /*@Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }*/

    @Bean
    public HelloWorldApiHystrixFallback helloWorldApiHystrixFallback(){
        return new HelloWorldApiHystrixFallback();
    }
}
