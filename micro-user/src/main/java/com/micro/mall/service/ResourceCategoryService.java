package com.micro.mall.service;

import com.micro.mall.model.ResourceCategory;

import java.util.List;

/**
 * 资源分类 Service
 * @author QAQ
 * @date 2021/5/19
 */

public interface ResourceCategoryService {

    /**
     * 获取所有资源分类
     */
    List<ResourceCategory> listAll();

    /**
     * 创建资源分类
     */
    int create(ResourceCategory category);

    /**
     * 修改资源
     */
    int update(Long id, ResourceCategory category);

    /**
     * 删除资源
     */
    int delete(Long id);
}
