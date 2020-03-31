package com.waimai.xu.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waimai.xu.goods.dao.ShopMapper;
import com.waimai.xu.goods.pojo.Shop;
import com.waimai.xu.goods.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Shop业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;


    /**
     * Shop条件+分页查询
     * @param shop 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Shop> findPage(Shop shop, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(shop);
        //执行搜索
        return new PageInfo<Shop>(shopMapper.selectByExample(example));
    }

    /**
     * Shop分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Shop> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Shop>(shopMapper.selectAll());
    }

    /**
     * Shop条件查询
     * @param shop
     * @return
     */
    @Override
    public List<Shop> findList(Shop shop){
        //构建查询条件
        Example example = createExample(shop);
        //根据构建的条件查询数据
        return shopMapper.selectByExample(example);
    }


    /**
     * Shop构建查询对象
     * @param shop
     * @return
     */
    public Example createExample(Shop shop){
        Example example=new Example(Shop.class);
        Example.Criteria criteria = example.createCriteria();
        if(shop!=null){
            // 
            if(!StringUtils.isEmpty(shop.getId())){
                    criteria.andEqualTo("id",shop.getId());
            }
            // 所属行业ID
            if(!StringUtils.isEmpty(shop.getIndustryId())){
                    criteria.andEqualTo("industryId",shop.getIndustryId());
            }
            // 所属组织ID
            if(!StringUtils.isEmpty(shop.getOrgId())){
                    criteria.andEqualTo("orgId",shop.getOrgId());
            }
            // 门店名字
            if(!StringUtils.isEmpty(shop.getName())){
                    criteria.andLike("name","%"+shop.getName()+"%");
            }
            // 门店图片
            if(!StringUtils.isEmpty(shop.getImage())){
                    criteria.andEqualTo("image",shop.getImage());
            }
            // 门店地址
            if(!StringUtils.isEmpty(shop.getAddr())){
                    criteria.andEqualTo("addr",shop.getAddr());
            }
            // 门店营业时间
            if(!StringUtils.isEmpty(shop.getTime())){
                    criteria.andEqualTo("time",shop.getTime());
            }
            // 门店电话
            if(!StringUtils.isEmpty(shop.getPhone())){
                    criteria.andEqualTo("phone",shop.getPhone());
            }
            // 排序
            if(!StringUtils.isEmpty(shop.getSeq())){
                    criteria.andEqualTo("seq",shop.getSeq());
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
        shopMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Shop
     * @param shop
     */
    @Override
    public void update(Shop shop){
        shopMapper.updateByPrimaryKey(shop);
    }

    /**
     * 增加Shop
     * @param shop
     */
    @Override
    public void add(Shop shop){
        shopMapper.insert(shop);
    }

    /**
     * 根据ID查询Shop
     * @param id
     * @return
     */
    @Override
    public Shop findById(Long id){
        return  shopMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Shop全部数据
     * @return
     */
    @Override
    public List<Shop> findAll() {
        return shopMapper.selectAll();
    }
}
