package com.ssm.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Test {
	
	private static void doTest3() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String encodedToken = "Basic " + Base64.encodeBase64String("zongcai:111111".getBytes());
		headers.set("Authorization", encodedToken);

		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		RestTemplate restTemplate = new RestTemplate();
		// 解决中文乱码问题
		resetCnMessageConverter(restTemplate);
		String serviceBase = "http://localhost/pm/rest/v1/project/{projectId}/workplan";
		String resourcePath = "/task/{taskId}";
		ResponseEntity<String> loginResponse = restTemplate.exchange(serviceBase + resourcePath, HttpMethod.GET, entity,
				String.class, "60838", "1000");
		if (loginResponse.getStatusCode() == HttpStatus.OK) {
			System.out.println(loginResponse.getBody());
		} else {
			System.out.println(loginResponse.getStatusCode());
		}
	}

	 /*
     *初始化RestTemplate，RestTemplate会默认添加HttpMessageConverter
     * 添加的StringHttpMessageConverter非UTF-8
     * 所以先要移除原有的StringHttpMessageConverter，
     * 再添加一个字符集为UTF-8的StringHttpMessageConvert
     * */
    private static void resetCnMessageConverter(RestTemplate restTemplate) {
        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
        HttpMessageConverter<?> converterTarget = null;
        for (HttpMessageConverter<?> item : converterList) {
            if (item.getClass() == StringHttpMessageConverter.class) {
                converterTarget = item;
                break;
            }
        }
        if (converterTarget != null) {
            converterList.remove(converterTarget);
        }
        HttpMessageConverter<?> converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converterList.add(converter);
    }

}
