package com.lihy.testWeb.controller;

import com.lihy.feign.api.test.HelloWorldApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试示例
 * 作为消费者消费服务
 * 采用feign调用接口
 * @author lihy
 * @date 2018/02/08
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @Autowired
    private HelloWorldApi helloWorldApi;

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public String sayHelloWorld(@RequestParam String name) {
        return helloWorldApi.sayHelloWorld(name);
    }
}
