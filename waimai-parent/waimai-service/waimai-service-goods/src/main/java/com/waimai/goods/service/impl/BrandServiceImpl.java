package com.waimai.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waimai.goods.dao.BrandMapper;
import com.waimai.goods.pojo.Brand;
import com.waimai.goods.service.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: waimai
 * @description:
 * @author: Mr.Xu
 * @create: 2020-03-30 14:50
 **/
@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> findList(Brand brand) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (brand != null) {
            if (!StringUtils.isEmpty(brand.getName())) {
                criteria.andLike("name", "%" + brand.getName() + "%");
            }
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter", brand.getLetter());
            }
        }

        return brandMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Brand> list = findList(brand);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Brand> brands = brandMapper.selectAll();
        return new PageInfo<>(brands);
    }
}
