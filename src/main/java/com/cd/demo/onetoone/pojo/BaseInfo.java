package com.cd.demo.onetoone.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_base_info")
public class BaseInfo implements Serializable{
	
	private static final long serialVersionUID = 913420504264213322L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	//指定主键生成策略
	private Integer id;
	
	private String name;
	
	private String age;
	
	@OneToOne(mappedBy="baseInfo")
	@JsonIgnoreProperties("baseInfo")
	private ComplexInfo complexInfo;
	
	public BaseInfo() {
		super();
	}

	public BaseInfo(Integer id, String name, String age, ComplexInfo complexInfo) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.complexInfo = complexInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public ComplexInfo getComplexInfo() {
		return complexInfo;
	}

	public void setComplexInfo(ComplexInfo complexInfo) {
		this.complexInfo = complexInfo;
	}

	
}
