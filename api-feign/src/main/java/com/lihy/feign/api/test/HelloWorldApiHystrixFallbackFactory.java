package com.lihy.feign.api.test;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author lihy
 * @date 2018/02/09
 */
@Component
public class HelloWorldApiHystrixFallbackFactory implements FallbackFactory<HelloWorldApi> {
    @Override
    public HelloWorldApi create(Throwable throwable) {
        return name -> "你好，" + name + "调用失败！";
    }
}
