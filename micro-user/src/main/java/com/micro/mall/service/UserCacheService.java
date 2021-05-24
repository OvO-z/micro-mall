package com.micro.mall.service;

import com.micro.mall.model.User;

/**
 * 用户缓存操作类
 * @author QAQ
 * @date 2021/5/24
 */

public interface UserCacheService {
    /**
     * 删除用户缓存
     */
    void deleteUser(Long userId);

    /**
     * 获取用户缓存
     */
    User getUser(Long userId);

    /**
     * 设置缓存用户信息
     */
    void setUser(User user);
}
