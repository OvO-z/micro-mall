package com.micro.mall.product.dao;

import com.micro.mall.product.model.ProductPropertyValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品参数自定义Dao
 * @author QAQ
 * @date 2021/5/14
 */

@Mapper
public interface ProductPropertyValueDao {
    /**
     * 批量创建
     */
    int batchInsert(@Param("list") List<ProductPropertyValue> list);
}
