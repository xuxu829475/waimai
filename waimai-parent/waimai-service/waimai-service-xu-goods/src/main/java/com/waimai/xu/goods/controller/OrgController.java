package com.waimai.xu.goods.controller;

import com.github.pagehelper.PageInfo;
import com.waimai.xu.goods.pojo.Org;
import com.waimai.xu.goods.service.OrgService;
import com.waimai.xu.goods.service.OrgService;
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
@Api(value = "OrgController")
@RestController
@RequestMapping("/org")
@CrossOrigin
public class OrgController {

    @Autowired
    private OrgService orgService;

    /***
     * Org分页条件搜索实现
     * @param org
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Org条件分页查询",notes = "分页条件查询Org方法详情",tags = {"OrgController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Org对象",value = "传入JSON数据",required = false) Org org, @PathVariable  int page, @PathVariable  int size){
        //调用OrgService实现分页条件查询Org
        PageInfo<Org> pageInfo = orgService.findPage(org, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Org分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Org分页查询",notes = "分页查询Org方法详情",tags = {"OrgController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OrgService实现分页查询Org
        PageInfo<Org> pageInfo = orgService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param org
     * @return
     */
    @ApiOperation(value = "Org条件查询",notes = "条件查询Org方法详情",tags = {"OrgController"})
    @PostMapping(value = "/search" )
    public Result<List<Org>> findList(@RequestBody(required = false) @ApiParam(name = "Org对象",value = "传入JSON数据",required = false) Org org){
        //调用OrgService实现条件查询Org
        List<Org> list = orgService.findList(org);
        return new Result<List<Org>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Org根据ID删除",notes = "根据ID删除Org方法详情",tags = {"OrgController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用OrgService实现根据主键删除
        orgService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Org数据
     * @param org
     * @param id
     * @return
     */
    @ApiOperation(value = "Org根据ID修改",notes = "根据ID修改Org方法详情",tags = {"OrgController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Org对象",value = "传入JSON数据",required = false) Org org,@PathVariable Long id){
        //设置主键值
        org.setId(id);
        //调用OrgService实现修改Org
        orgService.update(org);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Org数据
     * @param org
     * @return
     */
    @ApiOperation(value = "Org添加",notes = "添加Org方法详情",tags = {"OrgController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Org对象",value = "传入JSON数据",required = true) Org org){
        //调用OrgService实现添加Org
        orgService.add(org);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Org数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Org根据ID查询",notes = "根据ID查询Org方法详情",tags = {"OrgController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<Org> findById(@PathVariable Long id){
        //调用OrgService实现根据主键查询Org
        Org org = orgService.findById(id);
        return new Result<Org>(true,StatusCode.OK,"查询成功",org);
    }

    /***
     * 查询Org全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Org",notes = "查询所Org有方法详情",tags = {"OrgController"})
    @GetMapping
    public Result<List<Org>> findAll(){
        //调用OrgService实现查询所有Org
        List<Org> list = orgService.findAll();
        return new Result<List<Org>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
