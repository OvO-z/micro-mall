package com.micro.mall.common.api;

import com.micro.mall.common.validator.BatchMethod;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 批量操作 DTO
 * @author QAQ
 * @date 2021/5/8
 */

@Data
public class BatchParam<T> {

    @ApiModelProperty(value = "ID列表", required = true)
    private List<Long> ids;

    @ApiModelProperty(value = "更新数据")
    private T data;

    @NotEmpty
    @ApiModelProperty(value = "操作方法", required = true)
    @BatchMethod
    private String method;
}
