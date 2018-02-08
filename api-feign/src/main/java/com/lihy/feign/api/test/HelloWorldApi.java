package com.lihy.feign.api.test;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 公共接口api
 * 示例：寻找服务name为service-impl里的服务
 * @author lihy
 * @date 2018/02/07
 */
@FeignClient(value = "service-impl", path = "/hello")
public interface HelloWorldApi {

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    String sayHelloWorld(@RequestParam(value = "name") String name);
}
