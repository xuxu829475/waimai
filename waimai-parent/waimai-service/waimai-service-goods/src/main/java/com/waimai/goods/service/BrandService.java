package com.waimai.goods.service;

import com.github.pagehelper.PageInfo;
import com.waimai.goods.pojo.Brand;

import java.util.List;

/**
 * @program: waimai
 * @description:
 * @author: Mr.Xu
 * @create: 2020-03-30 14:49
 **/
public interface BrandService {

    /**
     * 查询所有商品
     * @return
     */
    List<Brand> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Brand findById(Integer id);

    /**
     * 新增
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改
     * @param brand
     */
    void update(Brand brand);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据条件查询
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);

    /**
     * 分页查询
     * @param brand
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Brand brand,Integer page,Integer size);
    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Integer page,Integer size);
}
