package com.waimai.xu.goods.service;

import com.github.pagehelper.PageInfo;
import com.waimai.xu.goods.pojo.Industry;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Industry业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface IndustryService {

    /***
     * Industry多条件分页查询
     * @param industry
     * @param page
     * @param size
     * @return
     */
    PageInfo<Industry> findPage(Industry industry, int page, int size);

    /***
     * Industry分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Industry> findPage(int page, int size);

    /***
     * Industry多条件搜索方法
     * @param industry
     * @return
     */
    List<Industry> findList(Industry industry);

    /***
     * 删除Industry
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Industry数据
     * @param industry
     */
    void update(Industry industry);

    /***
     * 新增Industry
     * @param industry
     */
    void add(Industry industry);

    /**
     * 根据ID查询Industry
     * @param id
     * @return
     */
     Industry findById(Integer id);

    /***
     * 查询所有Industry
     * @return
     */
    List<Industry> findAll();
}
