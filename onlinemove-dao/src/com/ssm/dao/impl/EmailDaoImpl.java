package com.ssm.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ssm.dao.EmailDao;
import com.ssm.vo.EmailLog;

public class EmailDaoImpl extends SqlSessionDaoSupport  implements EmailDao {

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}	
	
	@Override
	public void save(EmailLog elog) {
		getSqlSession().insert("addEmailLog", elog);
	}

	@Override
	public List<EmailLog> findListByUserId(int id) {
		List<EmailLog> list = getSqlSession().selectList("findListByUserId", id);
		return list;
	}

}
