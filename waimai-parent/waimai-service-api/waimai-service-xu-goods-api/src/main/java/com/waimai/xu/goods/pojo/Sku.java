package com.waimai.xu.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Sku构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Sku",value = "Sku")
@Table(name="sku")
public class Sku implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "id")
	private Long id;//

	@ApiModelProperty(value = "商品名",required = false)
    @Column(name = "name")
	private String name;//商品名

	@ApiModelProperty(value = "类目ID",required = false)
    @Column(name = "category_id")
	private Long categoryId;//类目ID

	@ApiModelProperty(value = "门店ID",required = false)
    @Column(name = "shop_id")
	private Long shopId;//门店ID

	@ApiModelProperty(value = "商品图片",required = false)
    @Column(name = "image")
	private String image;//商品图片

	@ApiModelProperty(value = "销量",required = false)
    @Column(name = "sale_num")
	private Integer saleNum;//销量

	@ApiModelProperty(value = "价格",required = false)
    @Column(name = "price")
	private String price;//价格

	@ApiModelProperty(value = "规格",required = false)
    @Column(name = "spec")
	private String spec;//规格

	@ApiModelProperty(value = "商品状态 1-正常，2-下架，3-删除",required = false)
    @Column(name = "status")
	private String status;//商品状态 1-正常，2-下架，3-删除

	@ApiModelProperty(value = "",required = false)
    @Column(name = "create_time")
	private Date createTime;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "update_time")
	private Date updateTime;//

	@ApiModelProperty(value = "掌柜描述",required = false)
    @Column(name = "desc")
	private String desc;//掌柜描述



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
	}
	//get方法
	public Long getCategoryId() {
		return categoryId;
	}

	//set方法
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	//get方法
	public Long getShopId() {
		return shopId;
	}

	//set方法
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	//get方法
	public String getImage() {
		return image;
	}

	//set方法
	public void setImage(String image) {
		this.image = image;
	}
	//get方法
	public Integer getSaleNum() {
		return saleNum;
	}

	//set方法
	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}
	//get方法
	public String getPrice() {
		return price;
	}

	//set方法
	public void setPrice(String price) {
		this.price = price;
	}
	//get方法
	public String getSpec() {
		return spec;
	}

	//set方法
	public void setSpec(String spec) {
		this.spec = spec;
	}
	//get方法
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	//get方法
	public Date getUpdateTime() {
		return updateTime;
	}

	//set方法
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	//get方法
	public String getDesc() {
		return desc;
	}

	//set方法
	public void setDesc(String desc) {
		this.desc = desc;
	}


}
