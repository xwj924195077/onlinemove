package com.ssm.service;

import java.util.List;

import com.ssm.vo.User;

public interface UserService {

	public List<User> getAllUsers();
	public boolean add(User user);  
    public boolean update(User user);  
    public boolean delete(int id);  
    public User findById(int id); 
    
	
}
