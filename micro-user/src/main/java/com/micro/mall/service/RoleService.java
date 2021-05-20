package com.micro.mall.service;

import com.micro.mall.model.Menu;
import com.micro.mall.model.Resource;
import com.micro.mall.model.Role;

import java.util.List;

/**
 * 角色管理 Service
 * @author QAQ
 * @date 2021/5/19
 */

public interface RoleService {
    /**
     * 添加角色
     */
    int create(Role role);

    /**
     * 修改角色信息
     */
    int update(Long id, Role role);

    /**
     * 批量删除角色
     */
    int delete(List<Long> ids);

    /**
     * 获取所有角色列表
     */
    List<Role> listAll();

    /**
     * 分页获取角色列表
     */
    List<Role> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 根据 用户ID 获取对应菜单
     */
    List<Menu> getMenus(Long userId);

    /**
     * 获取角色相关菜单
     */
    List<Menu> listMenu(Long roleId);

    /**
     * 获取角色相关资源
     */
    List<Resource> listResource(Long roleId);

    /**
     * 给角色分配菜单
     */
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     */
    int allocResource(Long roleId, List<Long> resourceIds);
}
