package com.micro.mall.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 商品SKU表
 * sku_stock
 * @author 24367
 * @date 2021-05-15 14:41:02
 */
@ApiModel(value="com.micro.mall.product.model.SkuStock")
@Data
public class SkuStock implements Serializable {
    /**
     * 主键（自增ID）
     */
    @ApiModelProperty(value="主键（自增ID）")
    private Long id;

    /**
     * 商品ID
     */
    @ApiModelProperty(value="商品ID")
    private Long productId;

    /**
     * SKU编码
     */
    @ApiModelProperty(value="SKU编码")
    private String skuCode;

    /**
     * 价格
     */
    @ApiModelProperty(value="价格")
    private BigDecimal price;

    /**
     * 库存
     */
    @ApiModelProperty(value="库存")
    private Integer stock;

    /**
     * 预警库存
     */
    @ApiModelProperty(value="预警库存")
    private Integer lowStock;

    /**
     * 销量
     */
    @ApiModelProperty(value="销量")
    private Integer sale;

    /**
     * 商品属性组合，json格式
     */
    @ApiModelProperty(value="商品属性组合，json格式")
    private String spData;

    private static final long serialVersionUID = 1L;
}