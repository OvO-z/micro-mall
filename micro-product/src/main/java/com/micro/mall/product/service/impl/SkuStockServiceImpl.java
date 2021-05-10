package com.micro.mall.product.service.impl;

import com.micro.mall.product.dao.SkuStockDao;
import com.micro.mall.product.mapper.SkuStockMapper;
import com.micro.mall.product.model.SkuStock;
import com.micro.mall.product.model.SkuStockExample;
import com.micro.mall.product.service.SkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 商品库存管理Service 实现类
 * @author QAQ
 * @date 2021/5/10
 */

@Service
public class SkuStockServiceImpl implements SkuStockService {

    @Autowired
    private SkuStockMapper skuStockMapper;

    @Autowired
    private SkuStockDao skuStockDao;

    @Override
    public List<SkuStock> getList(Long productId, String keyword) {
        SkuStockExample example = new SkuStockExample();
        SkuStockExample.Criteria criteria = example.createCriteria().andProductIdEqualTo(productId);
        if (!isEmpty(keyword)) {
            criteria.andSkuCodeLike("%"+keyword+"%");
        }
        return skuStockMapper.selectByExample(example);
    }

    @Override
    public int update(List<SkuStock> skuStocks) {
        return skuStockDao.batchReplace(skuStocks);
    }
}
