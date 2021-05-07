package com.micro.mall.product.mapper;

import com.micro.mall.product.model.SkuStock;

public interface SkuStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SkuStock record);

    int insertSelective(SkuStock record);

    SkuStock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SkuStock record);

    int updateByPrimaryKey(SkuStock record);
}