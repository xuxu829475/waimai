package com.waimai.xu.goods.service;

import com.github.pagehelper.PageInfo;
import com.waimai.xu.goods.pojo.Org;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Org业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface OrgService {

    /***
     * Org多条件分页查询
     * @param org
     * @param page
     * @param size
     * @return
     */
    PageInfo<Org> findPage(Org org, int page, int size);

    /***
     * Org分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Org> findPage(int page, int size);

    /***
     * Org多条件搜索方法
     * @param org
     * @return
     */
    List<Org> findList(Org org);

    /***
     * 删除Org
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Org数据
     * @param org
     */
    void update(Org org);

    /***
     * 新增Org
     * @param org
     */
    void add(Org org);

    /**
     * 根据ID查询Org
     * @param id
     * @return
     */
     Org findById(Long id);

    /***
     * 查询所有Org
     * @return
     */
    List<Org> findAll();
}
