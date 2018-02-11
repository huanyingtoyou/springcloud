package com.lihy.feign.api.test;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 服务熔断回调方法
 * @author lihy
 * @date 2018/02/09
 */
@Component
public class HelloWorldApiHystrixFallback implements HelloWorldApi {
    @Override
    public String sayHelloWorld(@RequestParam(value = "name") String name) {
        return "你好，" + name + "，该服务调用失败！";
    }
}
