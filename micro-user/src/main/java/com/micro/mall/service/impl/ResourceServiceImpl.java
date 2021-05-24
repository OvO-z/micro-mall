package com.micro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.micro.mall.common.constant.AuthConstant;
import com.micro.mall.common.service.RedisService;
import com.micro.mall.mapper.ResourceMapper;
import com.micro.mall.mapper.RoleMapper;
import com.micro.mall.mapper.RoleResourceRelationMapper;
import com.micro.mall.model.*;
import com.micro.mall.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleResourceRelationMapper roleResourceRelationMapper;
    @Autowired
    private RedisService redisService;
    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public int create(Resource resource) {
        int count = resourceMapper.insert(resource);
        initResourceRolesMap();
        return count;
    }

    @Override
    public int update(Long id, Resource resource) {
        resource.setId(id);
        int count = resourceMapper.updateByPrimaryKeySelective(resource);
        initResourceRolesMap();
        return count;
    }

    @Override
    public Resource getItem(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        int count = resourceMapper.deleteByPrimaryKey(id);
        initResourceRolesMap();
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
        Map<String, List<String>> resourceRolesMap = new TreeMap<>();
        List<Resource> resources = resourceMapper.selectByExample(new ResourceExample());
        List<Role> roles = roleMapper.selectByExample(new RoleExample());
        List<RoleResourceRelation> relations = roleResourceRelationMapper.selectByExample(new RoleResourceRelationExample());
        for (Resource resource: resources) {
            Set<Long> roleIds = relations
                    .stream()
                    .filter(item -> item.getResourceId().equals(resource.getId()))
                    .map(RoleResourceRelation::getRoleId)
                    .collect(Collectors.toSet());
            List<String> roleNames = roles
                    .stream()
                    .filter(item -> roleIds.contains(item.getId()))
                    .map(item -> item.getId() + "_" + item.getName())
                    .collect(Collectors.toList());
            resourceRolesMap.put("/"+ applicationName + resource.getUrl(), roleNames);
        }
        redisService.del(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        redisService.hSetAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRolesMap);
        return resourceRolesMap;
    }
}
