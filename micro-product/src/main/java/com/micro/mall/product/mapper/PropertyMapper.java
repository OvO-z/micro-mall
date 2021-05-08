package com.micro.mall.product.mapper;

import com.micro.mall.product.model.Property;
import com.micro.mall.product.model.PropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropertyMapper {
    long countByExample(PropertyExample example);

    int deleteByExample(PropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Property record);

    int insertSelective(Property record);

    List<Property> selectByExample(PropertyExample example);

    Property selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Property record, @Param("example") PropertyExample example);

    int updateByExample(@Param("record") Property record, @Param("example") PropertyExample example);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}