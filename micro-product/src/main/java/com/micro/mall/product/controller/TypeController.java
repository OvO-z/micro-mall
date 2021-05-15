package com.micro.mall.product.controller;

import com.micro.mall.common.api.CommonPage;
import com.micro.mall.common.api.CommonResult;
import com.micro.mall.product.model.Type;
import com.micro.mall.product.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品类型Controller
 * @author QAQ
 * @date 2021/5/10
 */

@Api("商品类型管理")
@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @ApiOperation("添加商品分类")
    @PostMapping
    @ResponseBody
    public CommonResult create(@RequestParam String name) {
        int count = typeService.create(name);
        return CommonResult.validCode(count);
    }

    @ApiOperation("修改商品类型")
    @PutMapping("/{id}")
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestParam String name) {
        int count = typeService.update(id, name);
        return CommonResult.validCode(count);
    }

    @ApiOperation("删除单个商品类型")
    @DeleteMapping("/{id}")
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = typeService.delete(id);
        return CommonResult.validCode(count);
    }

    @ApiOperation("获取单个商品属性分类信息")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<Type> getItem(@PathVariable Long id) {
        Type type = typeService.getItem(id);
        return CommonResult.success(type);
    }

    @ApiOperation("分页获取所有商品属性分类")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<CommonPage<Type>> getList(@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum) {
        List<Type> list = typeService.getList(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }
}
