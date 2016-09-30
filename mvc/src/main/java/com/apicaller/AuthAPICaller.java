package com.apicaller;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.utils.APIUtils;

/**
 *  Utility Class used in getting information from remote API and get response as JSON and parse the same.
 *  
 * @author nimesh
 *
 */
public class AuthAPICaller {
	private static String API_URL = "http://localhost:8080/authservice/";
	/** 
	 * 
	 * Method is responsible for calling remote API for authentication.
	 * 
	 * @param username
	 * @param password
	 * @return JSONObject
	 * @author nimesh
	 */
	public static JSONObject authenticateUser(String username,String password){
		JSONObject authJson = new JSONObject();
		
		if(username.equalsIgnoreCase("admin")){
			System.out.println(" authentication for admin ");
			authJson.put("status", "true");
			authJson.put("username","Admin");
			authJson.put("acl", "");
		}else{
			System.out.println(" authentication for other users :");
			RestTemplate restTemplate = new RestTemplate();
			JSONObject formData = new JSONObject();
			formData.put("json_api_call","call success");
			JSONObject formResponse = restTemplate.postForObject(API_URL+"auth", formData, JSONObject.class); 
			System.out.println(" response from rest : " + formResponse);
			authJson.put("status", formResponse.get("status"));
			authJson.put("username",username);
			authJson.put("acl", formResponse.get("acl"));
			
		}
		return authJson;
	}
}
