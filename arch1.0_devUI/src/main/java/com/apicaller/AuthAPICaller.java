package com.apicaller;

import org.json.JSONObject;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
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
	private static RestTemplate restTemplate = new RestTemplate();
	static
	{
		restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
	}
	public static JSONObject getResponseForRquest(String uri,JSONObject jsonObject){
		JSONObject formResponse = restTemplate.postForObject(API_URL+uri, jsonObject, JSONObject.class);
		return formResponse;
	}
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
		try{
			if(username.equalsIgnoreCase("admin")){
				System.out.println(" authentication for admin ");
				authJson.put("status", "true");
				authJson.put("username","Admin");
				authJson.put("acl", "");
			}else{
				System.out.println(" authentication for other users :");
				RestTemplate restTemplate = new RestTemplate();
				restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
				JSONObject formData = new JSONObject();
				formData.put("username",username);
				formData.put("password",password);
				JSONObject formResponse = restTemplate.postForObject(API_URL+"auth", formData, JSONObject.class); 
				System.out.println(" response from rest : " + formResponse);
				authJson.put("status", formResponse.get("status"));
				authJson.put("username",username);
				authJson.put("responseInfo", formResponse);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return authJson;
	}
}
