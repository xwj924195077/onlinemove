package com.ssm.service;

import java.util.List;

import com.ssm.dao.UserDao;
import com.ssm.vo.User;


public interface UserService {

	public void setUserDao(UserDao userDao);

	public List<User> findAll();

	public void add(User user);

	public User findById(int id);

	public void update(User user);

	public void delete(int id);

}
