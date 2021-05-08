package com.micro.mall.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.micro.mall.product.dto.BrandParam;
import com.micro.mall.product.mapper.BrandMapper;
import com.micro.mall.product.model.Brand;
import com.micro.mall.product.model.BrandExample;
import com.micro.mall.product.service.BrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * @Author: QAQ
 * @Date: 2021/5/7 15:39
 * @Description: 商品品牌 Service 实现类
 */
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> listAllBrand() {
        return brandMapper.selectByExample(new BrandExample());
    }

    @Override
    public int createBrand(BrandParam param) {
        Brand brand = new Brand();
        BeanUtils.copyProperties(param, brand);
        if (isEmpty(brand.getFirstWord())) {
            brand.setFirstWord(brand.getName().substring(0, 1));
        }
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, BrandParam param) {
        Brand brand = new Brand();
        BeanUtils.copyProperties(param, brand);
        brand.setId(id);
        if (isEmpty(brand.getFirstWord())) {
            brand.setFirstWord(brand.getName().substring(0, 1));
        }
        // TODO 更新商品中的品牌名
        return brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBrand(List<Long> ids) {
        BrandExample example = new BrandExample();
        example.createCriteria().andIdIn(ids);
        return brandMapper.deleteByExample(example);
    }

    @Override
    public List<Brand> listBrand(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        BrandExample example = new BrandExample();
        BrandExample.Criteria criteria = example.createCriteria();
        if (!isEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }

        return brandMapper.selectByExample(example);
    }

    @Override
    public Brand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateStatus(List<Long> ids, Integer status) {
        Brand brand = new Brand();
        brand.setStatus(status);
        BrandExample example = new BrandExample();
        example.createCriteria().andIdIn(ids);
        return brandMapper.updateByExample(brand, example);
    }
}
