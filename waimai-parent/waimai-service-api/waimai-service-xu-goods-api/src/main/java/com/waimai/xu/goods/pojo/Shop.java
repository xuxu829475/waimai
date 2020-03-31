package com.waimai.xu.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Shop构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Shop",value = "Shop")
@Table(name="shop")
public class Shop implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "id")
	private Long id;//

	@ApiModelProperty(value = "所属行业ID",required = false)
    @Column(name = "industry_id")
	private Long industryId;//所属行业ID

	@ApiModelProperty(value = "所属组织ID",required = false)
    @Column(name = "org_id")
	private Long orgId;//所属组织ID

	@ApiModelProperty(value = "门店名字",required = false)
    @Column(name = "name")
	private String name;//门店名字

	@ApiModelProperty(value = "门店图片",required = false)
    @Column(name = "image")
	private String image;//门店图片

	@ApiModelProperty(value = "门店地址",required = false)
    @Column(name = "addr")
	private String addr;//门店地址

	@ApiModelProperty(value = "门店营业时间",required = false)
    @Column(name = "time")
	private String time;//门店营业时间

	@ApiModelProperty(value = "门店电话",required = false)
    @Column(name = "phone")
	private String phone;//门店电话

	@ApiModelProperty(value = "排序",required = false)
    @Column(name = "seq")
	private Integer seq;//排序



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public Long getIndustryId() {
		return industryId;
	}

	//set方法
	public void setIndustryId(Long industryId) {
		this.industryId = industryId;
	}
	//get方法
	public Long getOrgId() {
		return orgId;
	}

	//set方法
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
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
	public String getImage() {
		return image;
	}

	//set方法
	public void setImage(String image) {
		this.image = image;
	}
	//get方法
	public String getAddr() {
		return addr;
	}

	//set方法
	public void setAddr(String addr) {
		this.addr = addr;
	}
	//get方法
	public String getTime() {
		return time;
	}

	//set方法
	public void setTime(String time) {
		this.time = time;
	}
	//get方法
	public String getPhone() {
		return phone;
	}

	//set方法
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//get方法
	public Integer getSeq() {
		return seq;
	}

	//set方法
	public void setSeq(Integer seq) {
		this.seq = seq;
	}


}
