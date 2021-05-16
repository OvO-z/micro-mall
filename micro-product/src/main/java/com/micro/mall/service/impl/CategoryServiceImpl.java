package com.micro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.micro.mall.dto.CategoryParam;
import com.micro.mall.mapper.CategoryMapper;
import com.micro.mall.model.Category;
import com.micro.mall.model.CategoryExample;
import com.micro.mall.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类 Service 实现类
 * @author QAQ
 * @date 2021/5/10
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int create(CategoryParam param) {
        Category category = new Category();
        category.setProductCount(0);
        BeanUtils.copyProperties(category, param);
        int count = categoryMapper.insertSelective(category);
        return count;
    }

    @Override
    public int update(Long id, CategoryParam param) {
        // TODO 更新商品分类
        return 0;
    }

    @Override
    public int delete(Long id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Category> getList(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        CategoryExample example = new CategoryExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public Category getItem(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateStatus(List<Long> ids, Integer status) {
        Category productCategory = new Category();
        productCategory.setStatus(status);
        CategoryExample example = new CategoryExample();
        example.createCriteria().andIdIn(ids);
        return categoryMapper.updateByExampleSelective(productCategory, example);
    }
}
