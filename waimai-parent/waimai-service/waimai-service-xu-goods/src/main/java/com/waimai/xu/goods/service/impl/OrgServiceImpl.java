package com.waimai.xu.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waimai.xu.goods.dao.OrgMapper;
import com.waimai.xu.goods.pojo.Org;
import com.waimai.xu.goods.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Org业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrgMapper orgMapper;


    /**
     * Org条件+分页查询
     * @param org 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Org> findPage(Org org, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(org);
        //执行搜索
        return new PageInfo<Org>(orgMapper.selectByExample(example));
    }

    /**
     * Org分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Org> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Org>(orgMapper.selectAll());
    }

    /**
     * Org条件查询
     * @param org
     * @return
     */
    @Override
    public List<Org> findList(Org org){
        //构建查询条件
        Example example = createExample(org);
        //根据构建的条件查询数据
        return orgMapper.selectByExample(example);
    }


    /**
     * Org构建查询对象
     * @param org
     * @return
     */
    public Example createExample(Org org){
        Example example=new Example(Org.class);
        Example.Criteria criteria = example.createCriteria();
        if(org!=null){
            // 
            if(!StringUtils.isEmpty(org.getId())){
                    criteria.andEqualTo("id",org.getId());
            }
            // 企业名称
            if(!StringUtils.isEmpty(org.getName())){
                    criteria.andLike("name","%"+org.getName()+"%");
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
        orgMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Org
     * @param org
     */
    @Override
    public void update(Org org){
        orgMapper.updateByPrimaryKey(org);
    }

    /**
     * 增加Org
     * @param org
     */
    @Override
    public void add(Org org){
        orgMapper.insert(org);
    }

    /**
     * 根据ID查询Org
     * @param id
     * @return
     */
    @Override
    public Org findById(Long id){
        return  orgMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Org全部数据
     * @return
     */
    @Override
    public List<Org> findAll() {
        return orgMapper.selectAll();
    }
}
