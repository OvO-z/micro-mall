package com.micro.mall.service;

import com.micro.mall.model.Menu;

import java.util.List;

/**
 * 菜单 Service
 * @author QAQ
 * @date 2021/5/19
 */

public interface MenuService {
    /**
     * 创建菜单
     */
    int create(Menu menu);

    /**
     * 修改菜单
     */
    int update(Long id, Menu menu);

    /**
     * 获取菜单详情
     */
    Menu getItem(Long id);

    /**
     * 删除菜单
     */
    int delete(Long id);

    /**
     * 分页查询菜单
     */
    List<Menu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 修改菜单显示状态
     */
    int updateHidden(Long id, Integer hidden);
}
