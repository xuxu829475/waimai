package com.waimai.xu.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Pec构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Pec",value = "Pec")
@Table(name="pec")
public class Pec implements Serializable{

	@ApiModelProperty(value = "ID",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//ID

	@ApiModelProperty(value = "名称",required = false)
    @Column(name = "name")
	private String name;//名称

	@ApiModelProperty(value = "规格选项",required = false)
    @Column(name = "options")
	private String options;//规格选项

	@ApiModelProperty(value = "排序",required = false)
    @Column(name = "seq")
	private Integer seq;//排序

	@ApiModelProperty(value = "门店ID",required = false)
    @Column(name = "shop_id")
	private Long shopId;//门店ID



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
	public String getOptions() {
		return options;
	}

	//set方法
	public void setOptions(String options) {
		this.options = options;
	}
	//get方法
	public Integer getSeq() {
		return seq;
	}

	//set方法
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	//get方法
	public Long getShopId() {
		return shopId;
	}

	//set方法
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}


}
