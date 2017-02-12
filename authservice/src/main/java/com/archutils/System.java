package com.archutils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;


public class System {
	public static ObjectMapper objectMapper;
	static{
		System.objectMapper = new ObjectMapper();
	}
	/*
	 * convertToJSON method helps in getting name value pair of bean variables/objects
	 */
	public static final String convertToJSON(Object object){
		try {
			return System.objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param fieldName
	 * @param cls
	 * @return
	 */
	private static PropertyDescriptor getGetterMethodOfField(String fieldName,Class<? extends Object> cls){
		try {
			return new PropertyDescriptor(fieldName, cls);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return null;
	}
	public final PropertyDescriptor[] getPropertyDescriptorsForBean() throws IntrospectionException{
		return Introspector.getBeanInfo(this.getClass()).getPropertyDescriptors();
	}
}
