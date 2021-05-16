package com.micro.mall.service.impl;

import com.micro.mall.dto.PropertyParam;
import com.micro.mall.mapper.PropertyMapper;
import com.micro.mall.model.Property;
import com.micro.mall.model.PropertyExample;
import com.micro.mall.service.PropertyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品属性Service 实现类
 * @author QAQ
 * @date 2021/5/11
 */

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public int create(PropertyParam param) {
        Property property = new Property();
        BeanUtils.copyProperties(param, property);
        return propertyMapper.insertSelective(property);
    }

    @Override
    public int update(Long id, PropertyParam param) {
        Property property = new Property();
        BeanUtils.copyProperties(param, property);
        property.setId(id);
        return propertyMapper.updateByPrimaryKeySelective(property);
    }

    @Override
    public Property getItem(Long id) {
        return propertyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(List<Long> ids) {
        PropertyExample example = new PropertyExample();
        example.createCriteria().andIdIn(ids);
        return propertyMapper.deleteByExample(example);
    }

    @Override
    public List<Property> getList(Long typeId) {
        PropertyExample example = new PropertyExample();
        example.createCriteria().andTypeIdEqualTo(typeId);
        return propertyMapper.selectByExample(example);
    }
}
