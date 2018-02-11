package com.lihy.feign.api.test;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 公共接口api
 * 示例：寻找服务name为service-impl里的服务
 * feign远程调用接口
 * FeignClient注解的name属性值要写服务提供者在注册中心注册的服务名称
 * FeignClient注解的fallback属性值表示远程调用失败时的回调类
 * 注：FeignClient注解还有fallbackFactory属性，该属性功能和fallback一致，都是提供降级服务回调的
 * @author lihy
 * @date 2018/02/07
 */
@FeignClient(value = "service-impl", path = "/hello", fallback = HelloWorldApiHystrixFallback.class)
public interface HelloWorldApi {

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    String sayHelloWorld(@RequestParam(value = "name") String name);
}
