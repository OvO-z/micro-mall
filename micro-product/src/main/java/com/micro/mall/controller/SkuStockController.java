package com.micro.mall.controller;

import com.micro.mall.common.api.CommonResult;
import com.micro.mall.model.SkuStock;
import com.micro.mall.service.SkuStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品库存管理Controller
 * @author QAQ
 * @date 2021/5/10
 */

@Api("sku商品库存管理")
@RestController
@RequestMapping("/sku")
public class SkuStockController {
    @Autowired
    private SkuStockService skuStockService;

    @ApiOperation("根据商品编号及编号模糊搜索sku库存")
    @GetMapping("/{pid}")
    @ResponseBody
    public CommonResult<List<SkuStock>> getList(@PathVariable Long pid, @RequestParam(value = "keyword",required = false) String keyword) {
        List<SkuStock> skuStocks = skuStockService.getList(pid, keyword);
        return CommonResult.success(skuStocks);
    }
    @ApiOperation("批量更新库存信息")
    @PostMapping("/batch")
    @ResponseBody
    public CommonResult update(@RequestBody List<SkuStock> skuStocks){
        int count = skuStockService.update(skuStocks);
        return CommonResult.validCode(count);
    }
}
