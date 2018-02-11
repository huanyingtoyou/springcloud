package com.lihy.feign.api.test;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lihy
 * @date 2018/02/11
 */
@Component
public class IntroduceApiHystrixFallback implements IntroduceApi {
    @Override
    public String introduce(String name) {
        return "你好，该服务调用失败！";
    }
}
