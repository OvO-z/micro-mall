package com.micro.mall.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.github.pagehelper.PageHelper;
import com.micro.mall.common.api.CommonResult;
import com.micro.mall.common.domain.UserDto;
import com.micro.mall.common.exception.Asserts;
import com.micro.mall.dao.UserRoleRelationDao;
import com.micro.mall.dto.UserParam;
import com.micro.mall.dto.UserPasswordParam;
import com.micro.mall.mapper.UserMapper;
import com.micro.mall.mapper.UserRoleRelationMapper;
import com.micro.mall.model.*;
import com.micro.mall.service.UserCacheService;
import com.micro.mall.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 用户管理Service 实现类
 * @author QAQ
 * @date 2021/5/21
 */

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserCacheService userCacheService;

    @Autowired
    private UserRoleRelationDao userRoleRelationDao;

    @Autowired
    private UserRoleRelationMapper userRoleRelationMapper;

    @Override
    public User getUserByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        if (!isEmpty(users)) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public User register(UserParam param) {
        User user = new User();
        BeanUtils.copyProperties(param, user);
        user.setCreateTime(new Date());
        user.setStatus(1);
        // 查询是否有相同用户
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(example);
        if (!isEmpty(users)) {
            return null;
        }
        // 将密码进行加密操作
        String encodePassword = BCrypt.hashpw(user.getPassword());
        user.setPassword(encodePassword);
        userMapper.insert(user);
        return user;
    }

    @Override
    public CommonResult login(String username, String password) {
        if (StrUtil.isEmpty(username) || StrUtil.isEmpty(password)) {
            Asserts.fail("用户名或密码不能为空");
        }
        // TODO 登录操作
        return null;
    }

    @Override
    public User getItem(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(keyword)) {
            criteria.andUsernameLike("%" + keyword + "%");
            example.or(example.createCriteria().andNicknameLike("%" + keyword + "%"));
        }
        return userMapper.selectByExample(example);
    }

    @Override
    public int update(Long id, User user) {
        user.setId(id);
        User rawUser = userMapper.selectByPrimaryKey(id);
        if(rawUser.getPassword().equals(user.getPassword())){
            //与原加密密码相同的不需要修改
            user.setPassword(null);
        }else{
            //与原加密密码不同的需要加密修改
            if(StrUtil.isEmpty(user.getPassword())){
                user.setPassword(null);
            }else{
                user.setPassword(BCrypt.hashpw(user.getPassword()));
            }
        }
        int count = userMapper.updateByPrimaryKeySelective(user);
        userCacheService.setUser(user);
        return 0;
    }

    @Override
    public int delete(Long id) {
        userCacheService.deleteUser(id);
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateRole(Long userId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        UserRoleRelationExample example = new UserRoleRelationExample();
        example.createCriteria().andUserIdEqualTo(userId);
        userRoleRelationMapper.deleteByExample(example);
        if (CollUtil.isNotEmpty(roleIds)) {
            List<UserRoleRelation> list = new ArrayList<>();
            roleIds.stream().forEach(roleId -> {
                UserRoleRelation relation = new UserRoleRelation();
                relation.setUserId(userId);
                relation.setRoleId(roleId);
                list.add(relation);
            });
            userRoleRelationDao.batchInsert(list);
        }
        return count;
    }

    @Override
    public List<Role> getRoles(Long userId) {
        return userRoleRelationDao.getRoles(userId);
    }

    @Override
    public List<Resource> getResources(Long userId) {
        return userRoleRelationDao.getResources(userId);
    }

    @Override
    public int updatePassword(UserPasswordParam param) {
        return 0;
    }

    @Override
    public UserDto loadByUsername(String username) {
        //获取用户信息
        User user = getUserByUsername(username);
        if (user != null) {
            List<Role> roles = getRoles(user.getId());
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            if(CollUtil.isNotEmpty(roles)) {
                List<String> roleStrs = roles
                        .stream()
                        .map(item -> item.getId() + "_" + item.getName())
                        .collect(Collectors.toList());
                userDto.setRoles(roleStrs);
            }
            return userDto;
        }
        return null;
    }

    @Override
    public User getCurrentUser() {
        // TODO 获取当前用户信息
        return null;
    }
}
