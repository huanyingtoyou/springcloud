package com.lihy.feign.api.test;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lihy
 * @date 2018/02/11
 */
@FeignClient(name = "service-second-impl", path = "/introduce", fallback = IntroduceApiHystrixFallback.class)
public interface IntroduceApi {
    /**
     * 这里必须要加注解RequestParam，否则调用时会直接进入降级服务方法
     * @param name
     * @return
     */
    @RequestMapping(value = "/introduceMe", method = RequestMethod.GET)
    String introduce(@RequestParam(value = "name") String name);
}
