package com.micro.mall.mapper;

import com.micro.mall.model.RoleResourceRelation;
import com.micro.mall.model.RoleResourceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleResourceRelationMapper {
    long countByExample(RoleResourceRelationExample example);

    int deleteByExample(RoleResourceRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleResourceRelation record);

    int insertSelective(RoleResourceRelation record);

    List<RoleResourceRelation> selectByExample(RoleResourceRelationExample example);

    RoleResourceRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoleResourceRelation record, @Param("example") RoleResourceRelationExample example);

    int updateByExample(@Param("record") RoleResourceRelation record, @Param("example") RoleResourceRelationExample example);

    int updateByPrimaryKeySelective(RoleResourceRelation record);

    int updateByPrimaryKey(RoleResourceRelation record);
}