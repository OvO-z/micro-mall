package com.micro.mall.product.mapper;

import com.micro.mall.product.model.ProductPropertyValue;

public interface ProductPropertyValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductPropertyValue record);

    int insertSelective(ProductPropertyValue record);

    ProductPropertyValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductPropertyValue record);

    int updateByPrimaryKey(ProductPropertyValue record);
}