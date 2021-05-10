package com.micro.mall.product.service;

import com.micro.mall.product.dto.CategoryParam;
import com.micro.mall.product.model.Category;

import java.util.List;

/**
 * 商品分类管理 Service
 * @author QAQ
 * @date 2021/5/10
 */

public interface CategoryService {
    /**
     * 创建商品分类
     */
    int create(CategoryParam param);

    /**
     * 修改商品分类
     */
    int update(Long id, CategoryParam param);


    /**
     * 删除商品分类
     */
    int delete(Long id);

    /**
     * 分页获取商品分类
     */
    List<Category> getList(Long parentId, Integer pageSize, Integer pageNum);


    /**
     * 根据ID获取商品分类
     */
    Category getItem(Long id);

    /**
     * 批量修改显示状态
     */
    int updateStatus(List<Long> ids, Integer status);


    /**
     * TODO 以层级形式获取商品分类
     * 以层级形式获取商品分类
     */
}
