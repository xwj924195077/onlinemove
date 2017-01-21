package com.ssm.dao;

import java.util.List;

import com.ssm.vo.EmailLog;

public interface EmailDao {
	
	public void save(EmailLog elog);  
//    public void betchUpdate(List<>);  
    public List<EmailLog> findListByUserId(int id);  

}
