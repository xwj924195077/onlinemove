package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.UserDao;
import com.ssm.service.UserService;
import com.ssm.vo.User;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public List<User> findAll(){
		return this.userDao.findAll();
	}
	public void add(User user){
		userDao.save(user);
	}
	public User findById(int id){
		return userDao.findById(id);
	}
	public void update(User user){
		userDao.update(user);
	}
	public void delete(int id){
		userDao.delete(id);
	}
	
}
