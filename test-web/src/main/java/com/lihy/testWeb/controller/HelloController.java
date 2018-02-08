package com.lihy.testWeb.controller;

import com.lihy.feign.api.test.HelloApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihy
 * @date 2018/02/07
 */
@RestController
public class HelloController {
    @Autowired
    HelloApi helloApi;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHello(@RequestParam String name){
        return helloApi.sayHelloFromClient("welcome");
    }
}
