package com.micro.mall.service;

import com.micro.mall.dto.BrandParam;
import com.micro.mall.model.Brand;

import java.util.List;

/**
 * @Author: QAQ
 * @Date: 2021/5/7 15:37
 * @Description: 商品品牌 Service
 */
public interface BrandService {
    /**
     *  获取所有品牌
     */
    List<Brand> listAllBrand();

    /**
     * 创建品牌
     */
    int createBrand(BrandParam param);

    /**
     * 修改品牌
     */
    int updateBrand(Long id, BrandParam param);

    /**
     * 删除品牌
     */
    int deleteBrand(Long id);

    /**
     * 批量删除品牌
     */
    int deleteBrand(List<Long> ids);

    /**
     * 分页查询品牌
     */
    List<Brand> listBrand(String keyword, int pageNum, int pageSize);

    /**
     * 获取品牌
     */
    Brand getBrand(Long id);

    /**
     * 修改显示状态
     */
    int updateStatus(List<Long> ids, Integer status);
}
