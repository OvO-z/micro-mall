package com.micro.mall.product.dao;

import com.micro.mall.product.model.Brand;

import java.util.List;

/**
 * @Author: QAQ
 * @Date: 2021/5/7 15:44
 * @Description: 品牌自定义查询 Dao
 */
public interface BrandDao {
    /**
     * 获取所有品牌
     * @return 品牌列表 List
     */
    List<Brand> listAllBrand();
}
