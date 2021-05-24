package com.micro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.micro.mall.dto.BrandParam;
import com.micro.mall.mapper.BrandMapper;
import com.micro.mall.mapper.ProductMapper;
import com.micro.mall.model.Brand;
import com.micro.mall.model.BrandExample;
import com.micro.mall.model.Product;
import com.micro.mall.model.ProductExample;
import com.micro.mall.service.BrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 商品品牌 Service 实现类
 * @author QAQ
 * @date 2021/5/7 15:39
 */

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private ProductMapper productMapper;

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
        brand.setCreateTime(new Date());
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
        // 更新商品中的品牌名
        Product product = new Product();
        product.setBrandName(brand.getName());
        ProductExample example = new ProductExample();
        example.createCriteria().andBrandIdEqualTo(id);
        productMapper.updateByExampleSelective(product, example);
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
