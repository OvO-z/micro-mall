package com.micro.mall.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * brand
 * @author 24367
 * @date 2021-04-26 10:15:17
 */
@ApiModel(value="com.micro.mall.product.model.Brand")
@Data
public class Brand {
    /**
     */
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 首字母
     */
    @ApiModelProperty(value="首字母")
    private String firstLetter;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    @ApiModelProperty(value="是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;

    /**
     * 是否显示
     */
    @ApiModelProperty(value="是否显示")
    private Integer showStatus;

    /**
     * 产品数量
     */
    @ApiModelProperty(value="产品数量")
    private Integer productCount;

    /**
     * 产品评论数量
     */
    @ApiModelProperty(value="产品评论数量")
    private Integer productCommentCount;

    /**
     * 品牌logo
     */
    @ApiModelProperty(value="品牌logo")
    private String logo;

    /**
     * 专区大图
     */
    @ApiModelProperty(value="专区大图")
    private String bigPic;

    /**
     * 品牌故事
     */
    @ApiModelProperty(value="品牌故事")
    private String brandStory;
}