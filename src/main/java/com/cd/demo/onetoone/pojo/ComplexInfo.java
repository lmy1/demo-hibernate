package com.cd.demo.onetoone.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_complex_info")
public class ComplexInfo implements Serializable{

	private static final long serialVersionUID = 433029988357632785L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	//指定主键生成策略
	private Integer id;
	
	private String diseaseType;
	
	private String diseaseMessage;
	
	@OneToOne
    @JoinColumn(name = "complex_info_id")
	@JsonIgnoreProperties("complexInfo")
	private BaseInfo baseInfo;

	public ComplexInfo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public String getDiseaseMessage() {
		return diseaseMessage;
	}

	public void setDiseaseMessage(String diseaseMessage) {
		this.diseaseMessage = diseaseMessage;
	}

	public BaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	
}
