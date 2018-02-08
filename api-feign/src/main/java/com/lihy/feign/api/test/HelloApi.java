package com.lihy.feign.api.test;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 寻找服务name为service-eureka里的服务
 * @author lihy
 * @date 2018/02/07
 */
@FeignClient(value = "service-eureka")
public interface HelloApi {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHelloFromClient(@RequestParam(value = "name") String name);
}
