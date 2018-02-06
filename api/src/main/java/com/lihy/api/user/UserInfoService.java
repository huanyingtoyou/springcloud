package com.lihy.api.user;

import com.lihy.common.model.User;

/**
 * 用户信息api
 * @author lihy
 * @date 2018/02/06
 */
public interface UserInfoService {
    /**
     * 根据用户id获取用户信息
     * @param userId
     * @return
     */
    User findUserInfoByUserId(String userId);

    /**
     * 根据用户id获取用户信息失败调用方法
     * @param userId
     * @return
     */
    String findUserInfoByUserIdFallBack(String userId);
}
