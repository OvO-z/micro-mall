package com.micro.mall.dao;

import com.micro.mall.model.Resource;
import com.micro.mall.model.Role;
import com.micro.mall.model.UserRoleRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义用户与角色管理Dao
 * @author QAQ
 * @date 2021/5/24
 */

@Mapper
public interface UserRoleRelationDao {
    /**
     * 批量插入用户角色关系
     */
    int batchInsert(@Param("list") List<UserRoleRelation> list);

    /**
     * 获取用户所有角色
     */
    List<Role> getRoles(@Param("userId") Long userId);

    /**
     * 获取用户所有可访问资源
     */
    List<Resource> getResources(@Param("userId") Long userId);

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getUserIds(@Param("resourceId") Long resourceId);
}
