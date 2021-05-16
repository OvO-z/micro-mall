package com.micro.mall.service;

import com.micro.mall.model.SkuStock;

import java.util.List;

/**
 * 商品库存管理Service
 * @author QAQ
 * @date 2021/5/10
 */

public interface SkuStockService {
    /**
     * 根据商品ID和skuCode 模糊搜索
     */
    List<SkuStock> getList(Long productId, String keyword);

    /**
     * 批量更新商品库存信息
     */
    int update(List<SkuStock> skuStocks);
}
