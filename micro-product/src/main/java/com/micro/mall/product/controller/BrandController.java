package com.micro.mall.product.controller;

import com.micro.mall.common.api.CommonPage;
import com.micro.mall.common.api.CommonResult;
import com.micro.mall.common.api.BatchParam;
import com.micro.mall.common.constant.BatchConstant;
import com.micro.mall.product.dto.BrandParam;
import com.micro.mall.product.model.Brand;
import com.micro.mall.product.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理Controller
 * @author QAQ
 * @date 2021/5/8
 */

@Api(tags = "品牌管理模块")
@RestController("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @ApiOperation("获取全部品牌列表")
    @GetMapping("/listAll")
    @ResponseBody
    public CommonResult<List<Brand>> getList() {
        return CommonResult.success(brandService.listAllBrand());
    }

    @ApiOperation("添加品牌")
    @PostMapping
    @ResponseBody
    public CommonResult create(@RequestBody BrandParam param) {
        int count = brandService.createBrand(param);
        return CommonResult.validCode(count);
    }

    @ApiOperation("更新品牌")
    @PutMapping("/{id}")
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody BrandParam param) {
        int count = brandService.updateBrand(id, param);
        return CommonResult.validCode(count);
    }

    @ApiOperation("删除品牌")
    @DeleteMapping("/{id}")
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = brandService.deleteBrand(id);
        return CommonResult.validCode(count);
    }

    @ApiOperation("根据品牌名称分页获取品牌列表")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<CommonPage<Brand>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<Brand> brandList = brandService.listBrand(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("根据编号查询品牌信息")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<Brand> getItem(@PathVariable("id") Long id) {
        return CommonResult.success(brandService.getBrand(id));
    }

    @ApiOperation("批量操作品牌")
    @PostMapping("/batch")
    @ResponseBody
    public CommonResult batch(@RequestBody BatchParam params) {
        switch (params.getMethod()) {
            case BatchConstant.UPDATE: {
                return CommonResult.validCode(brandService.updateStatus(params.getIds(), (Integer) params.getData()));
            }
            case BatchConstant.DELETE: {
                return CommonResult.validCode(brandService.deleteBrand(params.getIds()));
            }
            default: {
                return CommonResult.failed();
            }
        }
    }
}
