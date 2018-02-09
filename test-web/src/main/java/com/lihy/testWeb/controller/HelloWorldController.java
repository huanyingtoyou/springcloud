package com.lihy.testWeb.controller;

import com.lihy.feign.api.test.HelloWorldApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@Api(value = "hello", description = "测试", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloWorldController {
    @Autowired
    private HelloWorldApi helloWorldApi;

    @ApiOperation(value = "告诉world你是谁", notes = "告诉我你是谁，我就让你嘿嘿嘿")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String", paramType="query")
    })
    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public String sayHelloWorld(@RequestParam String name) {
        return helloWorldApi.sayHelloWorld(name);
    }
}
