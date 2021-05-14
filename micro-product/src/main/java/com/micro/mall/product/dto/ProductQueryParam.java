package com.micro.mall.product.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品查询参数
 * @author QAQ
 * @date 2021/5/14
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductQueryParam {
    @ApiModelProperty("上架状态")
    private Integer status;
    @ApiModelProperty("商品名称模糊关键字")
    private String keyword;
    @ApiModelProperty("商品分类编号")
    private Long categoryId;
    @ApiModelProperty("商品品牌编号")
    private Long brandId;
}
