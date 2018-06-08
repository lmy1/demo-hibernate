package com.cd.demo.onetomany.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 主表对象
 * @author li.mingyang
 *
 */
@Entity
@Table(name="tbl_customer")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 913420504264217322L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//指定主键生成策略
	private Integer id;
	
	private String custName;
	
	private String custPhone;
	
	/*
	 * targetEntity 对应的是实体类
	 * mappedBy 对应的是相应对象里的属性名称，
	 * cascade 是级联操作（维护外键）常用merge,remove,all
	 * fetch @OneToMany,@ManyToMany默认采用LAZY方式加载实体，而@OneToOne，@ManyToOne默认则采用EAGER方式加载
	 */
	@OneToMany(targetEntity=Linkman.class, mappedBy="customer", cascade = CascadeType.ALL)	
//	@JsonIgnoreProperties不同于@JsonIgnore在于，你可以注明该变量中的哪个属相不被序列化。从而允许在双向访问上都不存在环或是缺失。
	@JsonIgnoreProperties("customer")
	private Set<Linkman> linkmans;

	public Customer() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public Set<Linkman> getLinkmans() {
		return linkmans;
	}

	public void setLinkmans(Set<Linkman> linkmans) {
		this.linkmans = linkmans;
	}
	
	
}
