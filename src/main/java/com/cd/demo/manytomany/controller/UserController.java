package com.cd.demo.manytomany.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.demo.manytomany.dao.RoleDao;
import com.cd.demo.manytomany.dao.UserDao;
import com.cd.demo.manytomany.pojo.Role;
import com.cd.demo.manytomany.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@GetMapping("/{id}")
	public User findUser(@PathVariable("id")Integer id) {
		User user = userDao.findOne(id);
//		Set<Role> roles = user.getRoles();
//		roles.size();
		return user;
	}
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		
		Set<Role> roles = user.getRoles();
		if (null != roles) {
			for (Role role : roles) {
				Set<User> users = role.getUsers();
				if (null == users) {
					users = new HashSet<>();
				}
				users.add(user);
				role.setUsers(users);
			}
		}
		userDao.save(user);		//多对多需要双向保存
//		roleDao.save(roles);
		return null;
	}
	
	@DeleteMapping("/{ids}")
	public void deleteUsers(@PathVariable("ids")List<Integer> ids) {
		List<User> users = userDao.findAll(ids);
		userDao.deleteInBatch(users);
	}
	
	@PutMapping("/{userId}")
	public void updateUser(@PathVariable("userId")Integer userId, @RequestBody List<Integer> roleIds) {
		
		List<Role> roleList = roleDao.findAll(roleIds);
		Set<Role> currentRoles = new HashSet<>(roleList);
		
		User user = userDao.getOne(userId);
		Set<Role> oldRoles = user.getRoles();
		
		//先删除
		for (Role role : oldRoles) {
			Set<User> users = role.getUsers();
			users.remove(user);
			role.setUsers(users);
		}
		
		//再添加
		for (Role role : currentRoles) {
			Set<User> users = role.getUsers();
			users.add(user);
			role.setUsers(users);
		}
		
		oldRoles.addAll(currentRoles);
		userDao.save(user);
		
	}
	
	

}















