package com.utils;

import org.json.JSONObject;

/**
 * 
 * Class helps in providing utility methods to be used as single point of multi-purpose actions
 * @author nimesh
 *
 */
public class APIUtils {
	
	/**
	 * Method is responsible for checking if the jsonObject has desired key or not
	 * @param jsonObject
	 * @param expectedKey
	 * @return
	 */
	public static boolean isExpectedJSON(JSONObject jsonObject,String expectedKey){
		if(jsonObject.has(expectedKey) && jsonObject.get(expectedKey)!=null)
			return true;
		return false;
	}
}
