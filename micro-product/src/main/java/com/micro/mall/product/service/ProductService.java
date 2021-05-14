package com.micro.mall.product.service;

import com.micro.mall.product.dto.ProductParam;
import com.micro.mall.product.dto.ProductQueryParam;
import com.micro.mall.product.model.Product;

import java.util.List;

/**
 * 商品管理 Service
 * Created by QAQ on 2021/4/26
 * @author QAQ
 */


public interface ProductService {
    /**
     * 创建商品
     */
    int create(ProductParam param);

    /**
     * TODO
     * 根据商品编号获取更新信息
     */

    /**
     * 更新商品
     */
    int update(Long id, ProductParam param);

    /**
     * 分页查询商品
     */
    List<Product> list(ProductQueryParam param, Integer pageSize, Integer pageNum);

    /**
     * 批量修改商品上架状态
     */
    int updateStatus(List<Long> ids, Integer status);

    /**
     * 根据商品名称或者货号模糊查询
     */
    List<Product> list(String keyword);

}
