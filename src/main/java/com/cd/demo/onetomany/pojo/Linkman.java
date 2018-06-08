package com.cd.demo.onetomany.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * 从表对象
 * @author li.mingyang
 *
 */
@Entity
@Table(name="tbl_linkman")
public class Linkman implements Serializable{
	
	
	private static final long serialVersionUID = 6953390965250846623L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	
	private String lkmName;
	
	private String lkmGender;
	
	@ManyToOne  //建立一对多关系 (targetEntity=Customer.class)
	@JoinColumn(name="lkm_cust_id")	//用于定义主键字段和外键字段的对应关系。 name是当前表的外键字段，referencedColumnName是外键字段对应的主键的字段名称
	@JsonIgnoreProperties("linkmans")
	private Customer customer;

	public Linkman() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLkmName() {
		return lkmName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	public String getLkmGender() {
		return lkmGender;
	}

	public void setLkmGender(String lkmGender) {
		this.lkmGender = lkmGender;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
