package com.ssm.dao;

import java.util.List;

import com.ssm.vo.UserInfo;

public interface UserDao {
	public void save(UserInfo user);  
    public void update(UserInfo user);  
    public void delete(int id);  
    public UserInfo findById(int id);  
    public List<UserInfo> findAll(); 
}
