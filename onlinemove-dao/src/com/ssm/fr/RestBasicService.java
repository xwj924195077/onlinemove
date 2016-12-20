package com.ssm.fr;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;

public class RestBasicService {
	private String serviceAddress;
	private String serviceEntry;
	private String serviceRequest;
	private Map<String, Object> serviceResult = new HashMap<>();
	private String serviceToken;
	private RestTemplate restTemplate = new RestTemplate();
	private static Map<String, Map<String, String>> serviceConfigs = new HashMap();
	private int timeOut = -1;
			
	protected void init(String code) {
		
		Map serviceConfig = (Map) serviceConfigs.get(code);
		if (null == serviceConfig) {
			this.serviceAddress = code + "_SERVICE_ADDRESS";
			this.serviceToken = code + "_SERVICE_TOKEN";
			serviceConfig.put("ADDRESS", this.serviceAddress);
			serviceConfig.put("TOKEN", this.serviceToken);
			serviceConfigs.put(code, serviceConfig);
		} else {
			this.serviceAddress = ((String) serviceConfig.get("ADDRESS"));
			this.serviceToken = ((String) serviceConfig.get("TOKEN"));
		}
	}

	private Object _request() {
		try {
			String requestUrl = StringUtils.stripEnd(getServiceAddress(), "/")
					+ StringUtils.stripEnd(getServiceEntry(), "/") + "?token=" + getServiceToken();
			if (null == getServiceRequest()) {
				setServiceRequest("{}");
			}
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion "
					+ StringUtils.stripEnd(getServiceAddress(), "/") + StringUtils.stripEnd(getServiceEntry(), "/"));
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion " + getServiceRequest());

			MultiValueMap headers = new LinkedMultiValueMap();
			headers.add("Accept", "application/json;charset=utf-8");
			headers.add("Content-Type", "application/json;charset=utf-8");
			String requestBody = getServiceRequest();
			HttpEntity httpEntity = new HttpEntity(requestBody, headers);

			this.serviceResult = ((Map) this.restTemplate.postForObject(requestUrl, httpEntity, LinkedHashMap.class,
					new Object[0]));

			activateTimeOut();

			if (!this.serviceResult.containsKey("code")) {
				// this.serviceResult.put("code",
				// ServiceResponseCode.SERVER_ERROR);
				return null;
			}

			if (null != this.serviceResult.get("result"))
				return this.serviceResult.get("result");
		} catch (Exception e) {
			this.serviceResult.put("code", "error");
			e.printStackTrace();
		}

		return null;
	}

	private void activateTimeOut() {
		if (this.timeOut > 0) {
			Object factory = this.restTemplate.getRequestFactory();
			if ((factory instanceof SimpleClientHttpRequestFactory)) {
				System.out.println("HttpUrlConnection is used");
				((SimpleClientHttpRequestFactory) factory).setConnectTimeout(this.timeOut);
				((SimpleClientHttpRequestFactory) factory).setReadTimeout(this.timeOut);
			} else if ((factory instanceof HttpComponentsClientHttpRequestFactory)) {
				System.out.println("HttpClient is used");
				((HttpComponentsClientHttpRequestFactory) factory).setReadTimeout(this.timeOut);
				((HttpComponentsClientHttpRequestFactory) factory).setConnectTimeout(this.timeOut);
			}
		}
	}

	public Object request() {
		return _request();
	}

	public String getServiceAddress() {
		return this.serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public String getServiceEntry() {
		return this.serviceEntry;
	}

	public void setServiceEntry(String serviceEntry) {
		this.serviceEntry = serviceEntry;
	}

	public String getServiceRequest() {
		return this.serviceRequest;
	}

	public void setServiceRequest(HashMap<String, Object> request) {
		
		setServiceRequest(JSON.toJSONString(request));
	}

	public void setServiceRequest(String serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	public Map<String, Object> getServiceResult() {
		return this.serviceResult;
	}

	public void setServiceResult(Map<String, Object> serviceResult) {
		this.serviceResult = serviceResult;
	}

	public String getServiceToken() {
		return this.serviceToken;
	}

	public void setServiceToken(String serviceToken) {
		this.serviceToken = serviceToken;
	}

	public void setServiceRequestId(Object id) {
		setServiceRequest(id.toString());
	}

	public void setServiceRequestQuery(Object query, Object sort, Object pagination) {
		setServiceRequestQuery(query, sort, pagination, Boolean.valueOf(true));
	}

	public void setServiceRequestQuery(Object query, Object sort, Object pagination, Boolean excludeCount) {
		HashMap request = new HashMap();
		if (null != query) {
			request.put("query", query);
		}
		if (null != sort) {
			request.put("sort", sort);
		}
		if (null != pagination) {
			request.put("pagination", pagination);
		}

		setServiceRequest(JSON.toJSONString(request));
	}

	public void setServiceRequestQueryGroup(Object query, Object group) {
		HashMap request = new HashMap();
		if (null != query) {
			request.put("query", query);
		}

		request.put("group", group);

		setServiceRequest(JSON.toJSONString(request));
	}


	public String setServiceRequestUpdate(List<Map<String, Object>> updateList) {
			setServiceRequest(JSON.toJSONString(updateList));
			return getServiceRequest();
	}

	public String setServiceRequestCreateBatch(Object object) {
		if ((object instanceof String))
			setServiceRequest((String) object);
		else {
			setServiceRequest(JSON.toJSONString(object));
		}

		return getServiceRequest();
	}

	public String setServiceRequestCreate(Map request) {
		setServiceRequest(JSON.toJSONString(request));

		return getServiceRequest();
	}

	public Boolean checkSuccess() {
		if ((null != this.serviceResult) && (null != this.serviceResult.get("code"))
				&& (("1".equals(this.serviceResult.get("code")))
						|| (("0".equals(this.serviceResult.get("code")))
								&& (null != this.serviceResult.get("result"))))) {
			return Boolean.valueOf(true);
		}

		return Boolean.valueOf(false);
	}

	public int getTimeOut() {
		return this.timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
}
