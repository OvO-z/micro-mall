package com.micro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 后台角色资源关系表
 * role_resource_relation
 * @author 24367
 * @date 2021-05-18 15:00:35
 */

@Data
public class RoleResourceRelation implements Serializable {
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
     * 资源ID
     */
    @ApiModelProperty(value="资源ID")
    private Long resourceId;

    private static final long serialVersionUID = 1L;
}