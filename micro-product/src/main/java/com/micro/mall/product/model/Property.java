package com.micro.mall.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商品属性表
 * property
 * @author 24367
 * @date 2021-05-14 15:31:23
 */
@ApiModel(value="com.micro.mall.product.model.Property")
@Data
public class Property {
    /**
     * 自增ID
     */
    @ApiModelProperty(value="自增ID")
    private Long id;

    /**
     * 商品类型
     */
    @ApiModelProperty(value="商品类型")
    private Long typeId;

    /**
     * 属性名称
     */
    @ApiModelProperty(value="属性名称")
    private String name;

    /**
     * 属性值
     */
    @ApiModelProperty(value="属性值")
    private String value;
}