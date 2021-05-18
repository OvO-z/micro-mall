package com.micro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 后台用户和角色关系表
 * user_role_relation
 * @author 24367
 * @date 2021-05-18 15:00:35
 */

@Data
public class UserRoleRelation implements Serializable {
    /**
     */
    @ApiModelProperty(value="")
    private Long id;

    /**
     */
    @ApiModelProperty(value="")
    private Long adminId;

    /**
     */
    @ApiModelProperty(value="")
    private Long roleId;

    private static final long serialVersionUID = 1L;
}