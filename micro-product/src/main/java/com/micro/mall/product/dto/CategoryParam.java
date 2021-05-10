package com.micro.mall.product.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品分类参数
 * @author QAQ
 * @date 2021/5/10
 */

@Data
@EqualsAndHashCode
public class CategoryParam {
    private Long parentId;
    private String name;
    private String productUnit;
    private String productCount;
}
