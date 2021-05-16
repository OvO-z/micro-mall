package com.micro.mall.controller;

import com.micro.mall.common.api.BatchParam;
import com.micro.mall.common.api.CommonPage;
import com.micro.mall.common.api.CommonResult;
import com.micro.mall.common.constant.BatchConstant;
import com.micro.mall.dto.ProductParam;
import com.micro.mall.dto.ProductQueryParam;
import com.micro.mall.model.Product;
import com.micro.mall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品管理Controller
 * @author QAQ
 * @date 2021/5/8
 */

@Api(tags = "商品管理模块")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @ApiOperation("创建商品")
    @PostMapping
    @ResponseBody
    public CommonResult create(@RequestBody ProductParam param) {
        int count = productService.create(param);
        return CommonResult.validCode(count);
    }

    @ApiOperation("更新商品")
    @PutMapping("/{id}")
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody ProductParam param) {
        int count = productService.update(id, param);
        return CommonResult.validCode(count);
    }

    @ApiOperation("查询商品")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<CommonPage<Product>> getList(ProductQueryParam param,
                                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Product> list = productService.list(param, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("根据商品名称或货号模糊查询")
    @GetMapping(value = "/simpleList")
    @ResponseBody
    public CommonResult<List<Product>> getList(String keyword) {
        List<Product> list = productService.list(keyword);
        return CommonResult.success(list);
    }

    @ApiOperation("批量修改商品上架状态")
    @PostMapping("/batch")
    @ResponseBody
    public CommonResult batch(@RequestBody BatchParam params) {
        switch (params.getMethod()) {
            case BatchConstant.UPDATE: {
                return CommonResult.validCode(productService.updateStatus(params.getIds(), (Integer) params.getData()));
            }
            default: {
                return CommonResult.failed();
            }
        }
    }
}
