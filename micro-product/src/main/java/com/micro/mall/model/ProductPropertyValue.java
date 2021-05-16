package com.micro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 商品属性值表
 * product_property_value
 * @author 24367
 * @date 2021-05-15 14:41:02
 */
@ApiModel(value="com.micro.mall.product.model.ProductPropertyValue")
@Data
public class ProductPropertyValue implements Serializable {
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

    private static final long serialVersionUID = 1L;
}