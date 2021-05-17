package com.micro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 商品类型表
 * type
 * @author 24367
 * @date 2021-05-17 14:29:33
 */
@Data
public class Type implements Serializable {
    /**
     * 自增ID
     */
    @ApiModelProperty(value="自增ID")
    private Long id;

    /**
     * 商品类型名称
     */
    @ApiModelProperty(value="商品类型名称")
    private String typeName;

    /**
     * 商品描述
     */
    @ApiModelProperty(value="商品描述")
    private String description;

    private static final long serialVersionUID = 1L;
}