package com.waimai.xu.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waimai.xu.goods.dao.IndustryMapper;
import com.waimai.xu.goods.pojo.Industry;
import com.waimai.xu.goods.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Industry业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class IndustryServiceImpl implements IndustryService {

    @Autowired
    private IndustryMapper industryMapper;


    /**
     * Industry条件+分页查询
     * @param industry 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Industry> findPage(Industry industry, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(industry);
        //执行搜索
        return new PageInfo<Industry>(industryMapper.selectByExample(example));
    }

    /**
     * Industry分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Industry> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Industry>(industryMapper.selectAll());
    }

    /**
     * Industry条件查询
     * @param industry
     * @return
     */
    @Override
    public List<Industry> findList(Industry industry){
        //构建查询条件
        Example example = createExample(industry);
        //根据构建的条件查询数据
        return industryMapper.selectByExample(example);
    }


    /**
     * Industry构建查询对象
     * @param industry
     * @return
     */
    public Example createExample(Industry industry){
        Example example=new Example(Industry.class);
        Example.Criteria criteria = example.createCriteria();
        if(industry!=null){
            // ID
            if(!StringUtils.isEmpty(industry.getId())){
                    criteria.andEqualTo("id",industry.getId());
            }
            // 模板名称
            if(!StringUtils.isEmpty(industry.getName())){
                    criteria.andLike("name","%"+industry.getName()+"%");
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        industryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Industry
     * @param industry
     */
    @Override
    public void update(Industry industry){
        industryMapper.updateByPrimaryKey(industry);
    }

    /**
     * 增加Industry
     * @param industry
     */
    @Override
    public void add(Industry industry){
        industryMapper.insert(industry);
    }

    /**
     * 根据ID查询Industry
     * @param id
     * @return
     */
    @Override
    public Industry findById(Integer id){
        return  industryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Industry全部数据
     * @return
     */
    @Override
    public List<Industry> findAll() {
        return industryMapper.selectAll();
    }
}
