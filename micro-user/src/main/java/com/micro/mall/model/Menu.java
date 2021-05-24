package com.micro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * menu
 * @author 24367
 * @date 2021-05-24 17:25:02
 */
@ApiModel(value="com.micro.mall.model.Menu")
@Data
public class Menu implements Serializable {
    /**
     * 自增ID
     */
    @ApiModelProperty(value="自增ID")
    private Long id;

    /**
     * 父级ID
     */
    @ApiModelProperty(value="父级ID")
    private Long parentId;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value="菜单名称")
    private String title;

    /**
     * 菜单级数
     */
    @ApiModelProperty(value="菜单级数")
    private Integer level;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 前端名称
     */
    @ApiModelProperty(value="前端名称")
    private String name;

    /**
     * 前端图标
     */
    @ApiModelProperty(value="前端图标")
    private String icon;

    /**
     * 是否隐藏
     */
    @ApiModelProperty(value="是否隐藏")
    private Integer hidden;

    private static final long serialVersionUID = 1L;
}