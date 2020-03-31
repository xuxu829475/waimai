package com.waimai.xu.goods.controller;

import com.github.pagehelper.PageInfo;
import com.waimai.xu.goods.pojo.Pec;
import com.waimai.xu.goods.service.PecService;
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
@Api(value = "PecController")
@RestController
@RequestMapping("/pec")
@CrossOrigin
public class PecController {

    @Autowired
    private PecService pecService;

    /***
     * Pec分页条件搜索实现
     * @param pec
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Pec条件分页查询",notes = "分页条件查询Pec方法详情",tags = {"PecController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Pec对象",value = "传入JSON数据",required = false) Pec pec, @PathVariable  int page, @PathVariable  int size){
        //调用PecService实现分页条件查询Pec
        PageInfo<Pec> pageInfo = pecService.findPage(pec, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Pec分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Pec分页查询",notes = "分页查询Pec方法详情",tags = {"PecController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PecService实现分页查询Pec
        PageInfo<Pec> pageInfo = pecService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pec
     * @return
     */
    @ApiOperation(value = "Pec条件查询",notes = "条件查询Pec方法详情",tags = {"PecController"})
    @PostMapping(value = "/search" )
    public Result<List<Pec>> findList(@RequestBody(required = false) @ApiParam(name = "Pec对象",value = "传入JSON数据",required = false) Pec pec){
        //调用PecService实现条件查询Pec
        List<Pec> list = pecService.findList(pec);
        return new Result<List<Pec>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Pec根据ID删除",notes = "根据ID删除Pec方法详情",tags = {"PecController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用PecService实现根据主键删除
        pecService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Pec数据
     * @param pec
     * @param id
     * @return
     */
    @ApiOperation(value = "Pec根据ID修改",notes = "根据ID修改Pec方法详情",tags = {"PecController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Pec对象",value = "传入JSON数据",required = false) Pec pec,@PathVariable Long id){
        //设置主键值
        pec.setId(id);
        //调用PecService实现修改Pec
        pecService.update(pec);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Pec数据
     * @param pec
     * @return
     */
    @ApiOperation(value = "Pec添加",notes = "添加Pec方法详情",tags = {"PecController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Pec对象",value = "传入JSON数据",required = true) Pec pec){
        //调用PecService实现添加Pec
        pecService.add(pec);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Pec数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Pec根据ID查询",notes = "根据ID查询Pec方法详情",tags = {"PecController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<Pec> findById(@PathVariable Long id){
        //调用PecService实现根据主键查询Pec
        Pec pec = pecService.findById(id);
        return new Result<Pec>(true,StatusCode.OK,"查询成功",pec);
    }

    /***
     * 查询Pec全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Pec",notes = "查询所Pec有方法详情",tags = {"PecController"})
    @GetMapping
    public Result<List<Pec>> findAll(){
        //调用PecService实现查询所有Pec
        List<Pec> list = pecService.findAll();
        return new Result<List<Pec>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
