package com.micro.mall.dto;

import com.micro.mall.model.ProductPropertyValue;
import com.micro.mall.model.Product;
import com.micro.mall.model.SkuStock;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 商品参数
 * @author QAQ
 * @date 2021/5/11
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductParam extends Product {
    @ApiModelProperty("商品的sku库存信息")
    private List<SkuStock> skuStocks;
    @ApiModelProperty("商品参数及自定义规格属性")
    private List<ProductPropertyValue> productPropertyValues;
}
