package com.micro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 后台角色菜单关系表
 * role_menu_relation
 * @author 24367
 * @date 2021-05-24 17:25:02
 */
@ApiModel(value="com.micro.mall.model.RoleMenuRelation")
@Data
public class RoleMenuRelation implements Serializable {
    /**
     */
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 角色ID
     */
    @ApiModelProperty(value="角色ID")
    private Long roleId;

    /**
     * 菜单ID
     */
    @ApiModelProperty(value="菜单ID")
    private Long menuId;

    private static final long serialVersionUID = 1L;
}