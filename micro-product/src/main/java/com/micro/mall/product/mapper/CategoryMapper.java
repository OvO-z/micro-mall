package com.micro.mall.product.mapper;

import com.micro.mall.product.model.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKeyWithBLOBs(Category record);

    int updateByPrimaryKey(Category record);
}