package com.micro.mall.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.micro.mall.product.dao.ProductPropertyValueDao;
import com.micro.mall.product.dao.SkuStockDao;
import com.micro.mall.product.dto.ProductParam;
import com.micro.mall.product.dto.ProductQueryParam;
import com.micro.mall.product.mapper.ProductMapper;
import com.micro.mall.product.model.Product;
import com.micro.mall.product.model.ProductExample;
import com.micro.mall.product.model.SkuStock;
import com.micro.mall.product.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.sound.sampled.Port;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 商品管理 Service 实现类
 * Created by QAQ on 2021/4/26
 * @author QAQ
 */

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SkuStockDao skuStockDao;
    @Autowired
    private ProductPropertyValueDao productPropertyValueDao;


    @Override
    public int create(ProductParam param) {
        int count;
        Product product = param;
        product.setId(null);
        productMapper.insertSelective(product);
        Long productId = product.getId();
        // 处理SKU编码
        handleSkuStockCode(param.getSkuStocks(), productId);
        // 添加sku库存信息
        relateAndInsert(skuStockDao, param.getSkuStocks(), productId);
        // 添加商品参数
        relateAndInsert(productPropertyValueDao, param.getProductPropertyValues(), productId);
        count = 1;
        return count;
    }

    @Override
    public int update(Long id, ProductParam param) {
        int count;
        // 更新商品信息
        Product product = param;
        product.setId(id);
        productMapper.updateByPrimaryKeySelective(product);
        // 修改SKU编码
//        handleSkuStockCode(id, param); TODO
        return 0;
//
    }

    @Override
    public List<Product> list(ProductQueryParam param, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        if (!isEmpty(param.getStatus())) {
            criteria.andStatusEqualTo(param.getStatus());
        }
        if (!isEmpty(param.getKeyword())) {
            criteria.andNameLike("%" + param.getKeyword() + "%");
        }
        if (!isEmpty(param.getBrandId())) {
            criteria.andBrandIdEqualTo(param.getBrandId());
        }
        if (!isEmpty(param.getCategoryId())) {
            criteria.andCategoryIdEqualTo(param.getCategoryId());
        }
        return productMapper.selectByExample(example);
    }

    @Override
    public int updateStatus(List<Long> ids, Integer status) {
        Product product = new Product();
        product.setStatus(status);
        ProductExample example = new ProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(product, example);
    }

    @Override
    public List<Product> list(String keyword) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        if (!isEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        return productMapper.selectByExample(example);
    }

    private void handleSkuStockCode(List<SkuStock> skuStocks, Long productId) {
        if(CollectionUtils.isEmpty(skuStocks)) {
            return;
        }
        for (int i = 0; i < skuStocks.size(); i++) {
            SkuStock skuStock = skuStocks.get(i);
            if (isEmpty(skuStock.getSkuCode())) {
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                StringBuilder sb = new StringBuilder();
                sb.append(format.format(new Date()));
                sb.append(String.format("%04d", productId));
                sb.append(String.format("%03d", i+1));
                skuStock.setSkuCode(sb.toString());
            }
        }
    }

    private void handleUpdateSkuStockList(Long id, ProductParam param) {

    }

    private void relateAndInsert(Object dao, List data, Long productId) {
        try {
            if (CollectionUtils.isEmpty(data)) {
                return;
            }
            for (Object item : data) {
                Method setId = item.getClass().getMethod("setId", Long.class);
                setId.invoke(item, (Long) null);
                Method setProductId = item.getClass().getMethod("setProductId", Long.class);
                setProductId.invoke(item, productId);
            }
            Method insert = dao.getClass().getMethod("batchInsert", List.class);
            insert.invoke(dao, data);
        } catch (Exception e) {
            log.warn("创建产品出错:{}",e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
