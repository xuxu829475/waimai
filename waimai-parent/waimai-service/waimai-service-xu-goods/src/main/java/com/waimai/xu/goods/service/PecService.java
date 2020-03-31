package com.waimai.xu.goods.service;

import com.github.pagehelper.PageInfo;
import com.waimai.xu.goods.pojo.Pec;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Pec业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface PecService {

    /***
     * Pec多条件分页查询
     * @param pec
     * @param page
     * @param size
     * @return
     */
    PageInfo<Pec> findPage(Pec pec, int page, int size);

    /***
     * Pec分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Pec> findPage(int page, int size);

    /***
     * Pec多条件搜索方法
     * @param pec
     * @return
     */
    List<Pec> findList(Pec pec);

    /***
     * 删除Pec
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Pec数据
     * @param pec
     */
    void update(Pec pec);

    /***
     * 新增Pec
     * @param pec
     */
    void add(Pec pec);

    /**
     * 根据ID查询Pec
     * @param id
     * @return
     */
     Pec findById(Long id);

    /***
     * 查询所有Pec
     * @return
     */
    List<Pec> findAll();
}
