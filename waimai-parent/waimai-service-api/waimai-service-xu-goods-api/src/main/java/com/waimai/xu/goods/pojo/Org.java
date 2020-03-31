package com.waimai.xu.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Org构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Org",value = "Org")
@Table(name="org")
public class Org implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "id")
	private Long id;//

	@ApiModelProperty(value = "企业名称",required = false)
    @Column(name = "name")
	private String name;//企业名称



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


}
