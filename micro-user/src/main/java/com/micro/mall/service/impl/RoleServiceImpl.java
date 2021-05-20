package com.micro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.micro.mall.mapper.RoleMapper;
import com.micro.mall.mapper.RoleMenuRelationMapper;
import com.micro.mall.mapper.RoleResourceRelationMapper;
import com.micro.mall.model.*;
import com.micro.mall.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 角色管理Service 实现类
 * @author QAQ
 * @date 2021/5/20
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuRelationMapper roleMenuRelationMapper;

    @Autowired
    private RoleResourceRelationMapper roleResourceRelationMapper;

    @Override
    public int create(Role role) {
        role.setCreateTime(new Date());
        return roleMapper.insert(role);
    }

    @Override
    public int update(Long id, Role role) {
        role.setId(id);
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public int delete(List<Long> ids) {
        RoleExample example = new RoleExample();
        example.createCriteria().andIdIn(ids);
        int count = roleMapper.deleteByExample(example);
        // TODO initResourceRolesMap
        return count;
    }

    @Override
    public List<Role> listAll() {
        return roleMapper.selectByExample(new RoleExample());
    }

    @Override
    public List<Role> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        RoleExample example = new RoleExample();
        if (!isEmpty(keyword)) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<Menu> getMenus(Long userId) {
        // TODO
        return null;
    }

    @Override
    public List<Menu> listMenu(Long roleId) {
        // TODO
        return null;
    }

    @Override
    public List<Resource> listResource(Long roleId) {
        // TODO
        return null;
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        RoleMenuRelationExample example = new RoleMenuRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuRelationMapper.deleteByExample(example);
        for (Long menuId : menuIds) {
            RoleMenuRelation relation = new RoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            roleMenuRelationMapper.insert(relation);
        }
        return menuIds.size();
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        RoleResourceRelationExample example = new RoleResourceRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleResourceRelationMapper.deleteByExample(example);
        for (Long resourceId : resourceIds) {
            RoleResourceRelation relation = new RoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            roleResourceRelationMapper.insert(relation);
        }
        // TODO initResourceRoleMap
        return 0;
    }
}
