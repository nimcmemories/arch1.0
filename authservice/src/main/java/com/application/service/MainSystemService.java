package com.application.service;

import org.json.JSONObject;

import com.application.bean.MainSystemBean;

public interface MainSystemService {
	public JSONObject getMainSystemJSON();
	public String dev_saveMainSystem(JSONObject mainSystemBean);
}
