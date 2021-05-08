package com.micro.mall.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商品类型表
 * type
 * @author 24367
 * @date 2021-05-08 13:55:11
 */
@ApiModel(value="com.micro.mall.product.model.Type")
@Data
public class Type {
    /**
     * 自增ID
     */
    @ApiModelProperty(value="自增ID")
    private Long id;

    /**
     * 商品类型名称
     */
    @ApiModelProperty(value="商品类型名称")
    private String typeName;

    /**
     * 商品描述
     */
    @ApiModelProperty(value="商品描述")
    private String description;
}