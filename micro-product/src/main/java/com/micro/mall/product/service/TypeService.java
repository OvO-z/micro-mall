package com.micro.mall.product.service;

import com.micro.mall.product.model.Type;

import java.util.List;

/**
 * 商品类型Service
 * @author QAQ
 * @date 2021/5/10
 */

public interface TypeService {
    /**
     * 创建商品类型
     */
    int create(String name);

    /**
     * 修改商品类型
     */
    int update(Long id, String name);

    /**
     * 删除商品类型
     */
    int delete(Long id);

    /**
     * 获取商品类型信息
     */
    Type getItem(Long id);

    /**
     * 分页查询商品类型
     */
    List<Type> getList(Integer pageSize, Integer pageNum);

    /**
     * TODO 获取包含属性的商品类型
     */
}
