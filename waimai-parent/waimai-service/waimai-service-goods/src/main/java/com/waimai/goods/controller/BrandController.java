package com.waimai.goods.controller;

import com.github.pagehelper.PageInfo;
import com.waimai.goods.pojo.Brand;
import com.waimai.goods.service.BrandService;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: waimai
 * @description:
 * @author: Mr.Xu
 * @create: 2020-03-30 14:50
 **/
@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {

    @Resource
    private BrandService brandService;

    @GetMapping
    public Result findAll() {
        List<Brand> all = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK, "查询全部成功", all);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true, StatusCode.OK, "根据ID查询成功", brand);
    }

    @PostMapping
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result<>(true, StatusCode.OK, "新增成功");
    }

    @PutMapping
    public Result update(@RequestBody Brand brand) {
        brandService.update(brand);
        return new Result<>(true, StatusCode.OK, "修改成功");
    }

    @DeleteMapping("/{id}")
    public Result update(@PathVariable("id") Integer id) {
        brandService.delete(id);
        return new Result<>(true, StatusCode.OK, "删除成功");
    }

    @PostMapping("/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand) {
        List<Brand> list = brandService.findList(brand);
        return new Result<>(true, StatusCode.OK, "条件查询成功", list);
    }

    @GetMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findAllPage(@PathVariable("page") Integer page,
                                               @PathVariable("size") Integer size) {
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<>(true, StatusCode.OK, "查询全部分页成功", pageInfo);
    }

    @PostMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand,
                                            @PathVariable("page") Integer page,
                                            @PathVariable("size") Integer size) {
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result<>(true, StatusCode.OK, "条件查询分页成功", pageInfo);
    }

}
