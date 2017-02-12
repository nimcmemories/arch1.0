package com.system.hospital.bean;

import org.json.JSONObject;

/*
 * Base bean specially designed for H05p!tAl
 */
public abstract class BaseBean {
	public final JSONObject convertToJSON(){
		return com.archutils.System.convertToJSON(this);
	}
}
