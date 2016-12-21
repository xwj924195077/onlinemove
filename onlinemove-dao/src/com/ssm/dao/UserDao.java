package com.ssm.dao;

import java.util.List;

import com.ssm.vo.User;

public interface UserDao {
	public void save(User user);  
    public void update(User user);  
    public void delete(int id);  
    public User findById(int id);  
    public List<User> findAll(); 
}
