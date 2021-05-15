package com.micro.mall.product.controller;

import com.micro.mall.common.api.BatchParam;
import com.micro.mall.common.api.CommonPage;
import com.micro.mall.common.api.CommonResult;
import com.micro.mall.common.constant.BatchConstant;
import com.micro.mall.product.dto.CategoryParam;
import com.micro.mall.product.model.Category;
import com.micro.mall.product.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品分类Controller
 * @author QAQ
 * @date 2021/5/10
 */

@Api("商品分类管理")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation("添加商品分类")
    @PostMapping
    @ResponseBody
    public CommonResult create(@RequestBody CategoryParam param) {
        int count = categoryService.create(param);
        return CommonResult.validCode(count);
    }

    @ApiOperation("更新商品分类")
    @PutMapping("/{id}")
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody CategoryParam param) {
        int count = categoryService.update(id, param);
        return CommonResult.validCode(count);
    }

    @ApiOperation("分页查询商品分类")
    @GetMapping("/list/{parentId}")
    @ResponseBody
    public CommonResult<CommonPage<Category>> getList(@PathVariable Long parentId,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Category> list = categoryService.getList(parentId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("根据id获取商品分类")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<Category> getItem(@PathVariable Long id) {
        Category category = categoryService.getItem(id);
        return CommonResult.success(category);
    }

    @ApiOperation("删除商品分类")
    @DeleteMapping("/{id}")
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = categoryService.delete(id);
        return CommonResult.validCode(count);
    }

    @ApiOperation("批量操作商品分类")
    @PostMapping("/batch")
    @ResponseBody
    public CommonResult batch(@RequestBody BatchParam params) {
        switch (params.getMethod()) {
            case BatchConstant.UPDATE: {
                return CommonResult.validCode(categoryService.updateStatus(params.getIds(), (Integer) params.getData()));
            }
            default: {
                return CommonResult.failed();
            }
        }
    }
}
