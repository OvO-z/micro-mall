package com.micro.mall.service;

import com.micro.mall.common.api.CommonResult;
import com.micro.mall.common.domain.UserDto;
import com.micro.mall.dto.UserParam;
import com.micro.mall.dto.UserPasswordParam;
import com.micro.mall.model.Resource;
import com.micro.mall.model.Role;
import com.micro.mall.model.User;

import java.util.List;

/**
 * 用户管理 Service
 * @author QAQ
 * @date 2021/5/19
 */

public interface UserService {
    /**
     * 根据用户名获取用户
     */
    User getUserByUsername(String username);

    /**
     * 注册功能
     */
    User register(UserParam param);

    /**
     * 登录功能
     */
    CommonResult login(String username, String password);

    /**
     * 根据用户ID获取用户
     */
    User getItem(Long id);

    List<User> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 修改指定用户信息
     */
    int update(Long id, User user);

    /**
     * 删除指定用户
     */
    int delete(Long id);

    /**
     * 修改用户角色关系
     */
    int updateRole(Long userId, List<Long> roleIds);

    List<Role> getRoles(Long userId);
    /**
     * 获取用户可访问资源
     */
    List<Resource> getResources(Long userId);

    /**
     * 修改密码
     */
    int updatePassword(UserPasswordParam param);

    /**
     * 获取用户信息
     */
    UserDto loadByUsername(String username);

    /**
     * 获取当前登录用户
     */
    User getCurrentUser();
}
