package com.micro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 资源分类表
 * resource_category
 * @author 24367
 * @date 2021-05-20 16:12:16
 */
@ApiModel(value="com.micro.mall.model.ResourceCategory")
@Data
public class ResourceCategory implements Serializable {
    /**
     */
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 分类名称
     */
    @ApiModelProperty(value="分类名称")
    private String name;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 资源分类URL
     */
    @ApiModelProperty(value="资源分类URL")
    private String url;

    private static final long serialVersionUID = 1L;
}