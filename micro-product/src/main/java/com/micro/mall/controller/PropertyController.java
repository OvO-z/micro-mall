package com.micro.mall.controller;

import com.micro.mall.common.api.BatchParam;
import com.micro.mall.common.api.CommonResult;
import com.micro.mall.common.constant.BatchConstant;
import com.micro.mall.dto.PropertyParam;
import com.micro.mall.model.Property;
import com.micro.mall.service.PropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品属性管理 Controller
 * @author QAQ
 * @date 2021/5/11
 */
@Api("商品属性管理")
@RestController
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @ApiOperation("添加商品属性信息")
    @PostMapping
    @ResponseBody
    public CommonResult create(@RequestBody PropertyParam param) {
        int count = propertyService.create(param);
        return CommonResult.validCode(count);
    }

    @ApiOperation("修改商品属性信息")
    @PutMapping("/{id}")
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody PropertyParam param) {
        int count = propertyService.update(id, param);
        return CommonResult.validCode(count);
    }

    @ApiOperation("查询单个商品属性")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<Property> getItem(@PathVariable Long id) {
        Property property = propertyService.getItem(id);
        return CommonResult.success(property);
    }

    @ApiOperation("批量操作商品属性")
    @PostMapping("/batch")
    @ResponseBody
    public CommonResult delete(@RequestBody BatchParam params) {
        switch (params.getMethod()) {
            case BatchConstant.DELETE: {
                return CommonResult.validCode(propertyService.delete(params.getIds()));
            }
            default: {
                return CommonResult.failed();
            }
        }
    }
}
