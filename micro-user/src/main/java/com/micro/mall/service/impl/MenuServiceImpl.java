package com.micro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.micro.mall.mapper.MenuMapper;
import com.micro.mall.model.Menu;
import com.micro.mall.model.MenuExample;
import com.micro.mall.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单管理 Service 实现类
 * @author QAQ
 * @date 2021/5/19
 */

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public int create(Menu menu) {
        updateLevel(menu);
        return menuMapper.insertSelective(menu);
    }

    @Override
    public int update(Long id, Menu menu) {
        menu.setId(id);
        updateLevel(menu);
        return menuMapper.updateByPrimaryKey(menu);
    }

    @Override
    public Menu getItem(Long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Menu> list(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        MenuExample example = new MenuExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        return menuMapper.selectByExample(example);
    }

    @Override
    public int updateHidden(Long id, Integer hidden) {
        Menu menu = new Menu();
        menu.setId(id);
        menu.setHidden(hidden);
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    /**
     * 修改菜单层级
     */
    private void updateLevel(Menu menu) {
        if (menu.getParentId() == 0) {
            menu.setLevel(0);
        } else {
            Menu parent = menuMapper.selectByPrimaryKey(menu.getParentId());
            if (parent != null) {
                menu.setLevel(parent.getLevel() + 1);
            } else {
                menu.setLevel(0);
            }
        }
    }
}
