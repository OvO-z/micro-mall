package com.micro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * 商品属性参数
 * @author QAQ
 * @date 2021/5/11
 */

@Data
@EqualsAndHashCode
public class PropertyParam {

    @NotEmpty(message = "商品类型ID不能为空")
    @ApiModelProperty(value = "商品类型ID", required = true)
    private Long typeId;
    @NotEmpty(message = "属性名称不能为空")
    @ApiModelProperty("属性名称")
    private String name;
    @ApiModelProperty("属性值")
    private String value;
}
