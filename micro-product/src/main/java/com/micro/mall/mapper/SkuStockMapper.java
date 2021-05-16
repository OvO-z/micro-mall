package com.micro.mall.mapper;

import com.micro.mall.model.SkuStock;
import com.micro.mall.model.SkuStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SkuStockMapper {
    long countByExample(SkuStockExample example);

    int deleteByExample(SkuStockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SkuStock record);

    int insertSelective(SkuStock record);

    List<SkuStock> selectByExample(SkuStockExample example);

    SkuStock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SkuStock record, @Param("example") SkuStockExample example);

    int updateByExample(@Param("record") SkuStock record, @Param("example") SkuStockExample example);

    int updateByPrimaryKeySelective(SkuStock record);

    int updateByPrimaryKey(SkuStock record);
}