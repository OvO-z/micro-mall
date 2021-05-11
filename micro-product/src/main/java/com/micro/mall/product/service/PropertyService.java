package com.micro.mall.product.service;

import com.micro.mall.product.dto.PropertyParam;
import com.micro.mall.product.model.Property;

import java.util.List;

/**
 * 商品属性 Service
 * @author QAQ
 * @date 2021/5/10
 */

public interface PropertyService {
    /**
     * 添加商品属性
     */
    int create(PropertyParam param);

    /**
     * 修改商品属性
     */
    int update(Long id, PropertyParam param);

    /**
     * 获取单个商品属性信息
     */
    Property getItem(Long id);

    /**
     * 删除商品属性
     */
    int delete(List<Long> ids);

    /**
     * 根据商品类型获取商品属性
     */
    List<Property> getList(Long typeId);
}
