package com.apicaller;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class AuthAPICaller {
	private static String API_URL = "http://localhost:8080/authservice/";
	public static void authenticateUser(){
		//PENDING CODE HERE: check if service responds with positive or negative for authentication
		RestTemplate restTemplate = new RestTemplate();
		JSONObject formData = new JSONObject();
		formData.put("json_api_call","call success");
		JSONObject formResponse = restTemplate.postForObject(API_URL+"auth", formData, JSONObject.class); 
		System.out.println(" response from rest : " + formResponse);
		// if positive return true
	}
}
