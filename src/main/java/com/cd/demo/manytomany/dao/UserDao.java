package com.cd.demo.manytomany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.cd.demo.manytomany.pojo.User;

@Transactional
public interface UserDao extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>{
	@Modifying
	public void deleteByIdIn(List<Integer> ids);
}
