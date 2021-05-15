package com.micro.mall.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 商品基础信息表
 * product
 * @author 24367
 * @date 2021-05-15 14:41:02
 */
@ApiModel(value="com.micro.mall.product.model.Product")
@Data
public class Product implements Serializable {
    /**
     * 主键(自增ID)
     */
    @ApiModelProperty(value="主键(自增ID)")
    private Long id;

    /**
     * 商品名称
     */
    @ApiModelProperty(value="商品名称")
    private String name;

    /**
     * 分类ID(外键)
     */
    @ApiModelProperty(value="分类ID(外键)")
    private Long categoryId;

    /**
     * 分类名称
     */
    @ApiModelProperty(value="分类名称")
    private String categoryName;

    /**
     * 品牌ID(外键)
     */
    @ApiModelProperty(value="品牌ID(外键)")
    private Long brandId;

    /**
     * 品牌名称
     */
    @ApiModelProperty(value="品牌名称")
    private String brandName;

    /**
     * 图片
     */
    @ApiModelProperty(value="图片")
    private String pic;

    /**
     * 价格
     */
    @ApiModelProperty(value="价格")
    private BigDecimal price;

    /**
     * 单位
     */
    @ApiModelProperty(value="单位")
    private String unit;

    /**
     * 库存
     */
    @ApiModelProperty(value="库存")
    private Integer stock;

    /**
     * 标题
     */
    @ApiModelProperty(value="标题")
    private String title;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 状态：1-上架，0-下架
     */
    @ApiModelProperty(value="状态：1-上架，0-下架")
    private Integer status;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String note;

    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private Long createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 描述
     */
    @ApiModelProperty(value="描述")
    private String description;

    private static final long serialVersionUID = 1L;
}