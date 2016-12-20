package com.ssm.test;

import java.util.List;

import org.junit.Test;

import com.ssm.dao.impl.UserDaoImpl;
import com.ssm.vo.User;

public class TestUserDao {
	
	private UserDaoImpl userDao;
	
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	
	
	@Test
	public void testUserDao(){
		List<User> list=userDao.findAll();
		for(User user:list){
			System.out.println(user);
		}
	}
}

