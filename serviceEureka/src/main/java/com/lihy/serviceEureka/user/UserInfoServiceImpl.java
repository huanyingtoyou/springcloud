package com.lihy.serviceEureka.user;

import com.lihy.api.user.UserInfoService;
import com.lihy.common.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import java.util.UUID;

/**
 * 用户信息api实现
 * 添加熔断机制
 * @author lihy
 * @date 2018/02/06
 */
public class UserInfoServiceImpl implements UserInfoService {
    /**
     * 根据用户id获取用户信息
     * @param userId
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "findUserInfoByUserIdFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public User findUserInfoByUserId(String userId) {
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName("lihy");
        return user;
    }

    @Override
    public String findUserInfoByUserIdFallBack(String userId) {
        return "查询失败，用户不存在！";
    }
}
