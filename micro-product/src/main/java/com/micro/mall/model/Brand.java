package com.micro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品品牌
 * brand
 * @author 24367
 * @date 2021-05-17 14:29:33
 */
@Data
public class Brand implements Serializable {
    /**
     * 主键（自增ID）
     */
    @ApiModelProperty(value="主键（自增ID）")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 品牌网站
     */
    @ApiModelProperty(value="品牌网站")
    private String web;

    /**
     * 品牌序列
     */
    @ApiModelProperty(value="品牌序列")
    private Integer sort;

    /**
     * 品牌状态：1- 可用， 0为不可用 
     */
    @ApiModelProperty(value="品牌状态：1- 可用， 0为不可用 ")
    private Integer status;

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
     * 品牌首字母
     */
    @ApiModelProperty(value="品牌首字母")
    private String firstWord;

    private static final long serialVersionUID = 1L;
}