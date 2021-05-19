package com.micro.mall.service.impl;

import com.micro.mall.mapper.ResourceCategoryMapper;
import com.micro.mall.model.ResourceCategory;
import com.micro.mall.model.ResourceCategoryExample;
import com.micro.mall.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 资源分类 Service 属性类
 * @author QAQ
 * @date 2021/5/19
 */

@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<ResourceCategory> listAll() {
        return resourceCategoryMapper.selectByExample(new ResourceCategoryExample());
    }

    @Override
    public int create(ResourceCategory category) {
        category.setCreateTime(new Date());
        return resourceCategoryMapper.insert(category);
    }

    @Override
    public int update(Long id, ResourceCategory category) {
        category.setId(id);
        return resourceCategoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public int delete(Long id) {
        return resourceCategoryMapper.deleteByPrimaryKey(id);
    }
}
