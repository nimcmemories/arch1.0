package com.application.bean;

import java.io.IOException;

import org.json.JSONObject;



public class BaseBean {
	
	public final void jsonToBean(JSONObject jsonObject){
		try {
			com.archutils.System.objectMapper.readValue(jsonObject.toString(), this.getClass());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public final String convertToJSON(){
		return com.archutils.System.convertToJSON(this);
	}
	@Override
	public String toString(){
		System.out.println( "caller class " + this.getClass().getName());
		return this.convertToJSON().toString();
	}
}
