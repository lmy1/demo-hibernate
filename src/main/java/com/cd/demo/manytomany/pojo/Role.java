package com.cd.demo.manytomany.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_role")
public class Role implements Serializable{
	
	private static final long serialVersionUID = -495489962164772723L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String roleName;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createDate;

	@ManyToMany(cascade= {CascadeType.PERSIST})
	@JoinTable(name="tbl_user_role",	//中间表的名称
		joinColumns={@JoinColumn(name="role_id")},	//当前实体类所对应表所关联的中间表的外键字段
		inverseJoinColumns={@JoinColumn(name="user_id")}
	)
	@JsonIgnoreProperties("roles")
	private Set<User> users;
	
	
	public Role() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
}
