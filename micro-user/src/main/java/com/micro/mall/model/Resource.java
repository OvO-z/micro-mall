package com.micro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * resource
 * @author 24367
 * @date 2021-05-24 17:25:02
 */
@ApiModel(value="com.micro.mall.model.Resource")
@Data
public class Resource implements Serializable {
    /**
     * 自增ID
     */
    @ApiModelProperty(value="自增ID")
    private Long id;

    /**
     * 资源名称
     */
    @ApiModelProperty(value="资源名称")
    private String name;

    /**
     * 资源URL
     */
    @ApiModelProperty(value="资源URL")
    private String url;

    /**
     * 描述
     */
    @ApiModelProperty(value="描述")
    private String description;

    /**
     * 资源分类ID
     */
    @ApiModelProperty(value="资源分类ID")
    private Long categoryId;

    private static final long serialVersionUID = 1L;
}