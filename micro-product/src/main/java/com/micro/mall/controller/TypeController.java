package com.micro.mall.controller;

import com.micro.mall.common.api.CommonPage;
import com.micro.mall.common.api.CommonResult;
import com.micro.mall.model.Type;
import com.micro.mall.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
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
    public CommonResult create(@RequestParam @NotEmpty(message = "分类名称不能为空") String name) {
        int count = typeService.create(name);
        return CommonResult.validCode(count);
    }

    @ApiOperation("修改商品类型")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Long id, @RequestParam String name) {
        int count = typeService.update(id, name);
        return CommonResult.validCode(count);
    }

    @ApiOperation("删除单个商品类型")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Long id) {
        int count = typeService.delete(id);
        return CommonResult.validCode(count);
    }

    @ApiOperation("获取单个商品属性分类信息")
    @GetMapping("/{id}")
    public CommonResult<Type> getItem(@PathVariable Long id) {
        Type type = typeService.getItem(id);
        return CommonResult.success(type);
    }

    @ApiOperation("分页获取所有商品属性分类")
    @GetMapping("/list")
    public CommonResult<CommonPage<Type>> getList(@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum) {
        List<Type> list = typeService.getList(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }
}
