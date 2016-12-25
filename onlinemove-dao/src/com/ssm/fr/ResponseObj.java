package com.ssm.fr;

/**
 * 返回对象
 * @author Administrator
 *
 */
public class ResponseObj {
	
	//返回结果
	private Object result;
	//返回码
	private String code;
	//查询总条数
	private String count;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	

}
