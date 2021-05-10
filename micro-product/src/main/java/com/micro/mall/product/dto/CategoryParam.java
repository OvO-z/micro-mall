package com.micro.mall.product.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * 商品分类参数
 * @author QAQ
 * @date 2021/5/10
 */

@Data
@EqualsAndHashCode
public class CategoryParam {
    @ApiModelProperty("父级分类编号")
    private Long parentId;
    @NotEmpty
    @ApiModelProperty(value = "商品分类名称", required = true)
    private String name;
    @ApiModelProperty("分类单位")
    private String productUnit;
    @ApiModelProperty("是否进行显示")
    private Integer status;
    @Min(value = 0)
    @ApiModelProperty("排序")
    private Integer sort;
    @ApiModelProperty("图标")
    private String icon;
    @ApiModelProperty("描述")
    private String description;
}
