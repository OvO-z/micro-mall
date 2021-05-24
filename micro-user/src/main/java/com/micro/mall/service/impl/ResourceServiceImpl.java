package com.micro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.micro.mall.mapper.ResourceMapper;
import com.micro.mall.model.Resource;
import com.micro.mall.model.ResourceExample;
import com.micro.mall.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 资源管理Service 实现类
 * @author QAQ
 * @date 2021/5/20
 */

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public int create(Resource resource) {
        int count = resourceMapper.insert(resource);
        // TODO initResourceRolesMap
        return count;
    }

    @Override
    public int update(Long id, Resource resource) {
        resource.setId(id);
        int count = resourceMapper.updateByPrimaryKeySelective(resource);
        // TODO initResourceRolesMap
        return count;
    }

    @Override
    public Resource getItem(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        int count = resourceMapper.deleteByPrimaryKey(id);
        // TODO initResourceRolesMap
        return count;
    }

    @Override
    public List<Resource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ResourceExample example = new ResourceExample();
        ResourceExample.Criteria criteria = example.createCriteria();
        if (categoryId != null) {
            criteria.andCategoryIdEqualTo(categoryId);
        }
        if (!isEmpty(nameKeyword)) {
            criteria.andNameLike("%" + nameKeyword + "%");
        }
        if (!isEmpty(urlKeyword)) {
            criteria.andUrlLike("%" + urlKeyword + "%");
        }
        return resourceMapper.selectByExample(example);
    }

    @Override
    public List<Resource> listAll() {
        return resourceMapper.selectByExample(new ResourceExample());
    }

    @Override
    public Map<String, List<String>> initResourceRolesMap() {
        // TODO
        return null;
    }
}
