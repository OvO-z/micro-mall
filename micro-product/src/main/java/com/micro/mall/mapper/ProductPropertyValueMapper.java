package com.micro.mall.mapper;

import com.micro.mall.model.ProductPropertyValue;
import com.micro.mall.model.ProductPropertyValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductPropertyValueMapper {
    long countByExample(ProductPropertyValueExample example);

    int deleteByExample(ProductPropertyValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductPropertyValue record);

    int insertSelective(ProductPropertyValue record);

    List<ProductPropertyValue> selectByExample(ProductPropertyValueExample example);

    ProductPropertyValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductPropertyValue record, @Param("example") ProductPropertyValueExample example);

    int updateByExample(@Param("record") ProductPropertyValue record, @Param("example") ProductPropertyValueExample example);

    int updateByPrimaryKeySelective(ProductPropertyValue record);

    int updateByPrimaryKey(ProductPropertyValue record);
}