package com.micro.mall.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商品属性值表
 * product_property_value
 * @author 24367
 * @date 2021-05-07 15:34:40
 */
@ApiModel(value="com.micro.mall.product.model.ProductPropertyValue")
@Data
public class ProductPropertyValue {
    /**
     * 自增ID
     */
    @ApiModelProperty(value="自增ID")
    private Long id;

    /**
     * 商品ID
     */
    @ApiModelProperty(value="商品ID")
    private Long productId;

    /**
     * 属性ID
     */
    @ApiModelProperty(value="属性ID")
    private Long property;

    /**
     * 商品属性值
     */
    @ApiModelProperty(value="商品属性值")
    private String value;
}