package com.micro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * role
 * @author 24367
 * @date 2021-05-20 16:12:16
 */
@ApiModel(value="com.micro.mall.model.Role")
@Data
public class Role implements Serializable {
    /**
     * 自增ID
     */
    @ApiModelProperty(value="自增ID")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(value="描述")
    private String description;

    /**
     * 用户数量
     */
    @ApiModelProperty(value="用户数量")
    private Integer count;

    /**
     * 启用状态：0->禁用；1 -> 启用
     */
    @ApiModelProperty(value="启用状态：0->禁用；1 -> 启用")
    private Integer status;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序
")
    private Integer sort;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}