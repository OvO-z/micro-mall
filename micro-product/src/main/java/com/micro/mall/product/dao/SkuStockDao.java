package com.micro.mall.product.dao;

import com.micro.mall.product.model.SkuStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品SKU管理Dao
 * @author QAQ
 * @date 2021/5/10
 */

@Mapper
public interface SkuStockDao {
    /**
     * 批量插入操作
     */
    int batchInsert(@Param("list")List<SkuStock> list);

    /**
     * 批量插入或替换操作
     */
    int batchReplace(@Param("list")List<SkuStock> list);
}
