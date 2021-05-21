package com.micro.mall.dao;

import com.micro.mall.model.Menu;
import com.micro.mall.model.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义角色管理Dao
 * @author QAQ
 * @date 2021/5/21
 */
@Mapper
public interface RoleDao {
    /**
     * 根据用户ID获取菜单
     */
    List<Menu> getMenus(@Param("userId") Long userId);

    /**
     * 根据角色ID获取菜单
     */
    List<Menu> getMenuByRoleId(@Param("roleId") Long roleId);

    /**
     * 根据角色ID 获取资源
     */
    List<Resource> getResourceByRoleId(@Param("roleId") Long roleId);
}
