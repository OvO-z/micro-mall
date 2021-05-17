package com.micro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品分类
 * category
 * @author 24367
 * @date 2021-05-17 14:29:33
 */
@Data
public class Category implements Serializable {
    /**
     * 主键(自增ID)
     */
    @ApiModelProperty(value="主键(自增ID)")
    private Long id;

    /**
     * 上级分类的编号：0表示一级分类
     */
    @ApiModelProperty(value="上级分类的编号：0表示一级分类")
    private Long parentId;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

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
     * 状态：0->不显示；1->显示
     */
    @ApiModelProperty(value="状态：0->不显示；1->显示")
    private Integer status;

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