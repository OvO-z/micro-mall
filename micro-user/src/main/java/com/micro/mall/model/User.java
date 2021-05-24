package com.micro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user
 * @author 24367
 * @date 2021-05-24 17:25:02
 */
@ApiModel(value="com.micro.mall.model.User")
@Data
public class User implements Serializable {
    /**
     * 自增ID
     */
    @ApiModelProperty(value="自增ID")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    private String password;

    /**
     * 昵称
     */
    @ApiModelProperty(value="昵称")
    private String nickname;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 账号启用状态：0-> 禁用； 1-> 启用
     */
    @ApiModelProperty(value="账号启用状态：0-> 禁用； 1-> 启用")
    private Integer status;

    private static final long serialVersionUID = 1L;
}