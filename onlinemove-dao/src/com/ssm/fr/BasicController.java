package com.ssm.fr;


import com.alibaba.fastjson.JSON;

public class BasicController {
	
	public Object initParams(String obj) {
		
		com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(obj);
		String type = jsonObject.get("type").toString();
		Object data = jsonObject.get("data").toString();
		if ("query".equals(type) && null != data) {
			
		}
		return null;
		
	}
	
	

}
