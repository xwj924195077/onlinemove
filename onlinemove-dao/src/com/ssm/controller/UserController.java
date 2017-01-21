package com.ssm.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.dao.UserDao;
import com.ssm.fr.BasicController;
import com.ssm.fr.Constant;
import com.ssm.fr.ResponseObj;
import com.ssm.vo.UserInfo;

@Controller
@RequestMapping("/user")
public class UserController extends BasicController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/getAllUser", method = RequestMethod.POST)
	@ResponseBody
	public String getAllUser() {
		List<UserInfo> list = null;
		ResponseObj responseObj = new ResponseObj();;
		responseObj.setCode(Constant.ERROR);
		try {
			list = userDao.findAll();
			responseObj.setCode(Constant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		responseObj.setResult(list);
		return JSON.toJSONString(responseObj);
	}
	
	@RequestMapping(value = "/findOneUserById", method = RequestMethod.POST)
	@ResponseBody
	public String list(@RequestBody String request) {
		UserInfo user = null;
		ResponseObj responseObj = new ResponseObj();;
		responseObj.setCode(Constant.ERROR);
		try {
			JSONObject json = JSON.parseObject(request);
			int id = (int) json.get("data");
			user = userDao.findById(id);
			responseObj.setCode(Constant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		responseObj.setResult(user);
		return JSON.toJSONString(responseObj);
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	@ResponseBody
	public String add(@RequestBody String request) throws Exception {

		System.out.println(request);
		ResponseObj responseObj = new ResponseObj();
		responseObj.setCode(Constant.ERROR);
		try {
			JSONObject json = JSON.parseObject(request);
			Map<String, Object> data = (Map<String, Object>) json.get("data");
			if (null != data) {
				UserInfo user = new UserInfo();
				BeanUtils.populate(user, data);
				userDao.save(user);
				responseObj.setCode(Constant.SUCCESS);
				responseObj.setResult(Constant.TRUE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setResult(Constant.FALSE);
		}
		return JSON.toJSONString(responseObj);

	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public String update(@RequestBody String request) throws Exception {

		ResponseObj responseObj = new ResponseObj();
		responseObj.setCode(Constant.ERROR);
		try {
			JSONObject json = JSON.parseObject(request);
			Map<String, Object> data = (Map<String, Object>) json.get("data");
			if (null != data) {
				UserInfo user = new UserInfo();
				BeanUtils.populate(user, data);
				userDao.update(user);
				responseObj.setCode(Constant.SUCCESS);
				responseObj.setResult(Constant.TRUE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setResult(Constant.FALSE);
		}
		return JSON.toJSONString(responseObj);
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public String delete(@RequestBody String request) {
		ResponseObj responseObj = new ResponseObj();
		responseObj.setCode(Constant.ERROR);
		try {
			JSONObject json = JSON.parseObject(request);
			int id = (int) json.get("data");
			userDao.delete(id);
			responseObj.setCode(Constant.SUCCESS);
			responseObj.setResult(Constant.TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setResult(Constant.FALSE);
		}
		return JSON.toJSONString(responseObj);

	}

	public UserDao getUserService() {
		return userDao;
	}

	public void setUserService(UserDao userDao) {
		this.userDao = userDao;
	}
}
