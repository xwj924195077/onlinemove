package com.ssm.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssm.dao.UserDao;
import com.ssm.vo.User;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	@Autowired
	@Override
public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	super.setSqlSessionFactory(sqlSessionFactory);
}	
	@Override
	public void save(User user) {
		getSqlSession().insert("add",user);
	}

	@Override
	public void update(User user) {
		getSqlSession().update("update", user);
	}

	@Override
	public void delete(int id) {
		getSqlSession().delete("delete",id);
	}

	@Override
	public User findById(int id) {
		User user =getSqlSession().selectOne("findById",id);
		return user;
	}

	@Override
	public List<User> findAll() { 
		return getSqlSession().selectList("findAll");
	}

}
