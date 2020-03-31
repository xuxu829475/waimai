package com.waimai.xu.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waimai.xu.goods.dao.PecMapper;
import com.waimai.xu.goods.pojo.Pec;
import com.waimai.xu.goods.service.PecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Pec业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class PecServiceImpl implements PecService {

    @Autowired
    private PecMapper pecMapper;


    /**
     * Pec条件+分页查询
     * @param pec 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Pec> findPage(Pec pec, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pec);
        //执行搜索
        return new PageInfo<Pec>(pecMapper.selectByExample(example));
    }

    /**
     * Pec分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Pec> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Pec>(pecMapper.selectAll());
    }

    /**
     * Pec条件查询
     * @param pec
     * @return
     */
    @Override
    public List<Pec> findList(Pec pec){
        //构建查询条件
        Example example = createExample(pec);
        //根据构建的条件查询数据
        return pecMapper.selectByExample(example);
    }


    /**
     * Pec构建查询对象
     * @param pec
     * @return
     */
    public Example createExample(Pec pec){
        Example example=new Example(Pec.class);
        Example.Criteria criteria = example.createCriteria();
        if(pec!=null){
            // ID
            if(!StringUtils.isEmpty(pec.getId())){
                    criteria.andEqualTo("id",pec.getId());
            }
            // 名称
            if(!StringUtils.isEmpty(pec.getName())){
                    criteria.andLike("name","%"+pec.getName()+"%");
            }
            // 规格选项
            if(!StringUtils.isEmpty(pec.getOptions())){
                    criteria.andEqualTo("options",pec.getOptions());
            }
            // 排序
            if(!StringUtils.isEmpty(pec.getSeq())){
                    criteria.andEqualTo("seq",pec.getSeq());
            }
            // 门店ID
            if(!StringUtils.isEmpty(pec.getShopId())){
                    criteria.andEqualTo("shopId",pec.getShopId());
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
        pecMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Pec
     * @param pec
     */
    @Override
    public void update(Pec pec){
        pecMapper.updateByPrimaryKey(pec);
    }

    /**
     * 增加Pec
     * @param pec
     */
    @Override
    public void add(Pec pec){
        pecMapper.insert(pec);
    }

    /**
     * 根据ID查询Pec
     * @param id
     * @return
     */
    @Override
    public Pec findById(Long id){
        return  pecMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Pec全部数据
     * @return
     */
    @Override
    public List<Pec> findAll() {
        return pecMapper.selectAll();
    }
}
