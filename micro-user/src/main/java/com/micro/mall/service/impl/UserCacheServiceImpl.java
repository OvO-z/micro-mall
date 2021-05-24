package com.micro.mall.service.impl;

import com.micro.mall.common.service.RedisService;
import com.micro.mall.model.User;
import com.micro.mall.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * UserCacheService实现类
 * @author QAQ
 * @date 2021/5/24
 */

@Service
public class UserCacheServiceImpl implements UserCacheService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.user}")
    private String REDIS_KEY;


    @Override
    public void deleteUser(Long userId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY + ":" + userId;
        redisService.del(key);
    }

    @Override
    public User getUser(Long userId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY + ":" + userId;
        return (User) redisService.get(key);
    }

    @Override
    public void setUser(User user) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY + ":" + user.getId();
        redisService.set(key, user, REDIS_EXPIRE);
    }
}
