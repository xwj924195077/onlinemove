package com.ssm.fr;

public class ServerSettingService  extends RestBasicService {
	
    public ServerSettingService(String code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	private final String QUERY_SERVER_PORT_SETTING_ENTRY = "/serverSetting/queryServerPortSetting";
   
//    public  ServerSettingService() {
//    	setServiceAddress("168.0.0.1:8080");
//    	setServiceToken("");
//    }
    
    
//	public void fetchServerPortSettingByCode(String code) {
//		Map<String, Object> query = new HashMap<String, Object>();
//		query.put("code", code);
//		setServiceEntry(QUERY_SERVER_PORT_SETTING_ENTRY);
//		setServiceRequestQuery(query, null, null);
//	}
}
