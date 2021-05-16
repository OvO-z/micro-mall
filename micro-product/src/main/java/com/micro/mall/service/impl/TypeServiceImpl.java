package com.micro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.micro.mall.mapper.TypeMapper;
import com.micro.mall.model.Type;
import com.micro.mall.model.TypeExample;
import com.micro.mall.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品类型Service 实现类
 * @author QAQ
 * @date 2021/5/10
 */

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public int create(String name) {
        Type type = new Type();
        type.setTypeName(name);
        return typeMapper.insertSelective(type);
    }

    @Override
    public int update(Long id, String name) {
        Type type = new Type();
        type.setTypeName(name);
        type.setId(id);
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public int delete(Long id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Type getItem(Long id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Type> getList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return typeMapper.selectByExample(new TypeExample());
    }
}
