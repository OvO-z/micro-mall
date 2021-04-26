package com.micro.mall.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * category
 * @author 24367
 * @date 2021-04-26 10:15:17
 */
@ApiModel(value="com.micro.mall.product.model.Category")
@Data
public class Category {
    /**
     */
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 上级分类编号：0->一级分类
     */
    @ApiModelProperty(value="上级分类编号：0->一级分类")
    private Long parentId;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 分类级别： 0->1级；1->2级
     */
    @ApiModelProperty(value="分类级别： 0->1级；1->2级")
    private Integer level;

    /**
     * 商品数量
     */
    @ApiModelProperty(value="商品数量")
    private Integer productCount;

    /**
     * 商品单位
     */
    @ApiModelProperty(value="商品单位")
    private String productUnit;

    /**
     * 是否显示在导航栏：0->不显示；1->显示
     */
    @ApiModelProperty(value="是否显示在导航栏：0->不显示；1->显示")
    private Integer navStatus;

    /**
     * 显示状态：0->不显示；1->显示
     */
    @ApiModelProperty(value="显示状态：0->不显示；1->显示")
    private Integer showStatus;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 图标
     */
    @ApiModelProperty(value="图标")
    private String icon;

    /**
     * 关键字
     */
    @ApiModelProperty(value="关键字")
    private String keywords;

    /**
     * 描述
     */
    @ApiModelProperty(value="描述")
    private String description;
}