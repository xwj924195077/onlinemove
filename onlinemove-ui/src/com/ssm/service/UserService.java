package com.ssm.service;

import java.util.List;

import com.ssm.vo.UserInfo;

public interface UserService {

	public List<UserInfo> getAllUsers();
	public boolean add(UserInfo user);  
    public boolean update(UserInfo user);  
    public boolean delete(int id);  
    public UserInfo findById(int id); 
}
