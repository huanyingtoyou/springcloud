package com.lihy.serviceImpl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试示例
 * 具体的服务提供端实现的内容
 * @author lihy
 * @date 2018/02/08
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public String sayHelloWorld(@RequestParam String name){
        return "你好，世界！我是" + name;
    }
}
