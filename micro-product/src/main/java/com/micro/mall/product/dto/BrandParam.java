package com.micro.mall.product.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 品牌传递参数
 * @author: QAQ
 * @date: 2021/5/7 15:50
 * @Description:
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class BrandParam {
    @NotEmpty
    @ApiModelProperty(value = "品牌名称", required = true)
    private String name;

    @ApiModelProperty(value="品牌网站")
    private String web;

    @Min(value = 0)
    @ApiModelProperty(value="品牌序列")
    private Integer sort;

    @ApiModelProperty(value="品牌状态：1- 可用， 0为不可用 ")
    private Integer status;

    @ApiModelProperty(value="创建人")
    private Long createBy;

    @ApiModelProperty(value="创建时间")
    private Date createTime;

    @ApiModelProperty(value="品牌首字母")
    private String firstWord;
}
