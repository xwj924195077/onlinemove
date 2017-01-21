package com.ssm.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssm.dao.UserDao;
import com.ssm.vo.UserInfo;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public void save(UserInfo user) {
		getSqlSession().insert("addUserInfo", user);
	}

	@Override
	public void update(UserInfo user) {
		getSqlSession().update("updateUserInfo", user);
	}

	@Override
	public void delete(int id) {
		getSqlSession().delete("deleteUserInfo", id);
	}

	@Override
	public UserInfo findById(int id) {
		UserInfo user = getSqlSession().selectOne("findUserInfoById", id);
		return user;
	}

	@Override
	public List<UserInfo> findAll() {
		return getSqlSession().selectList("findAllUserInfo");
	}

}
