package com.waimai.xu.goods.controller;

import com.github.pagehelper.PageInfo;
import com.waimai.xu.goods.pojo.Industry;
import com.waimai.xu.goods.service.IndustryService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "IndustryController")
@RestController
@RequestMapping("/industry")
@CrossOrigin
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    /***
     * Industry分页条件搜索实现
     * @param industry
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Industry条件分页查询",notes = "分页条件查询Industry方法详情",tags = {"IndustryController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Industry对象",value = "传入JSON数据",required = false) Industry industry, @PathVariable  int page, @PathVariable  int size){
        //调用IndustryService实现分页条件查询Industry
        PageInfo<Industry> pageInfo = industryService.findPage(industry, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Industry分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Industry分页查询",notes = "分页查询Industry方法详情",tags = {"IndustryController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用IndustryService实现分页查询Industry
        PageInfo<Industry> pageInfo = industryService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param industry
     * @return
     */
    @ApiOperation(value = "Industry条件查询",notes = "条件查询Industry方法详情",tags = {"IndustryController"})
    @PostMapping(value = "/search" )
    public Result<List<Industry>> findList(@RequestBody(required = false) @ApiParam(name = "Industry对象",value = "传入JSON数据",required = false) Industry industry){
        //调用IndustryService实现条件查询Industry
        List<Industry> list = industryService.findList(industry);
        return new Result<List<Industry>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Industry根据ID删除",notes = "根据ID删除Industry方法详情",tags = {"IndustryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用IndustryService实现根据主键删除
        industryService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Industry数据
     * @param industry
     * @param id
     * @return
     */
    @ApiOperation(value = "Industry根据ID修改",notes = "根据ID修改Industry方法详情",tags = {"IndustryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Industry对象",value = "传入JSON数据",required = false) Industry industry,@PathVariable Integer id){
        //设置主键值
        industry.setId(id);
        //调用IndustryService实现修改Industry
        industryService.update(industry);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Industry数据
     * @param industry
     * @return
     */
    @ApiOperation(value = "Industry添加",notes = "添加Industry方法详情",tags = {"IndustryController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Industry对象",value = "传入JSON数据",required = true) Industry industry){
        //调用IndustryService实现添加Industry
        industryService.add(industry);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Industry数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Industry根据ID查询",notes = "根据ID查询Industry方法详情",tags = {"IndustryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Industry> findById(@PathVariable Integer id){
        //调用IndustryService实现根据主键查询Industry
        Industry industry = industryService.findById(id);
        return new Result<Industry>(true,StatusCode.OK,"查询成功",industry);
    }

    /***
     * 查询Industry全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Industry",notes = "查询所Industry有方法详情",tags = {"IndustryController"})
    @GetMapping
    public Result<List<Industry>> findAll(){
        //调用IndustryService实现查询所有Industry
        List<Industry> list = industryService.findAll();
        return new Result<List<Industry>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
