package com.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.ssm.fr.Constant;
import com.ssm.fr.RestBasicService;
import com.ssm.service.UserService;
import com.ssm.vo.User;

@Service("userService")
public class UserServiceImpl extends RestBasicService implements UserService {
	private final static String GET_ALL_USER = "/user/getAllUser";
	private final static String CREATE_USER = "/user/createUser";
	private final static String DELETE_USER = "/user/deleteUser";
	private final static String UPDATE_USER = "/user/updateUser";
	private final static String FIND_ONE_USER_BY_ID = "/user/findOneUserById";

	public UserServiceImpl() {
		setServiceAddress("http://127.0.0.1:8082/onlinemove-dao");
		setServiceToken("xwj");
	}

	public List<User> getAllUsers() {
		setServiceEntry(GET_ALL_USER);
		String type = Constant.QUERY;
		List<User> list = null;
		Map<String, Object> resultMap = setServiceRequest(type, null);
		if (null != resultMap) {
			String code = (String) resultMap.get("code");
			if (code.equals(Constant.SUCCESS)) {
				List<Map<String, Object>> results = (List<Map<String, Object>>) resultMap.get("result");
				list = new ArrayList<User>();
				for (Map map : results) {
					User user = new User();
					try {
						BeanUtils.populate(user, map);
						list.add(user);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return list;

	}

	@Override
	public boolean add(User user) {
		setServiceEntry(CREATE_USER);
		String type = Constant.CREATE;
		if (null != user) {
			Map<String, Object> resultMap = setServiceRequest(type, user);
			if (null != resultMap) {
				String code = (String) resultMap.get("code");
				if (code.equals(Constant.SUCCESS)) {
					return Boolean.valueOf(resultMap.get("result").toString());
				}
			}
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		setServiceEntry(UPDATE_USER);
		String type = Constant.UPDATE;
		if (null != user) {
			Map<String, Object> resultMap = setServiceRequest(type, user);
			if (null != resultMap) {
				String code = (String) resultMap.get("code");
				if (code.equals(Constant.SUCCESS)) {
					return Boolean.valueOf(resultMap.get("result").toString());
				}
			}
		}
		return false;

	}

	@Override
	public boolean delete(int id) {
		setServiceEntry(DELETE_USER);
		String type = Constant.DELETE;
		Map<String, Object> resultMap = setServiceRequest(type, id);
		if (null != resultMap) {
			String code = (String) resultMap.get("code");
			if (code.equals(Constant.SUCCESS)) {
				return Boolean.valueOf(resultMap.get("result").toString());
			}
		}
		return false;
	}

	@Override
	public User findById(int id) {
		setServiceEntry(FIND_ONE_USER_BY_ID);
		String type = Constant.QUERY;
		Map<String, Object> resultMap = setServiceRequest(type, id);
		User user = null;
		if (null != resultMap) {
			user = new User();
			String code = (String) resultMap.get("code");
			if (code.equals(Constant.SUCCESS)) {
				Map<String, Object> map = (Map<String, Object>) resultMap.get("result");
				try {
					BeanUtils.populate(user, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

}
