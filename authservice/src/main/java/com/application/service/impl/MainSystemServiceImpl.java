package com.application.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONArray;
import org.json.JSONObject;

import com.application.bean.MainSystemBean;
import com.application.dao.MainSystemProxy;
import com.application.service.MainSystemService;

public class MainSystemServiceImpl implements MainSystemService{

	private MainSystemProxy mainSystemProxy;
	
	public void setMainSystemProxy(MainSystemProxy mainSystemProxy) {
		this.mainSystemProxy = mainSystemProxy;
	}

	@Override
	public JSONObject getMainSystemJSON() {
		List<MainSystemBean> listMainSystemBean =  mainSystemProxy.getMainSystemList();
		JSONObject jsonMainSystem = new JSONObject();
		JSONArray jsonArrayMainSystemBean = new JSONArray();
		for(MainSystemBean msb : listMainSystemBean){
			jsonArrayMainSystemBean.put(msb.convertToJSON());
		}
		return jsonMainSystem.put("jsonArrayMainSystemBean", jsonArrayMainSystemBean);
	}

	@Override
	public String dev_saveMainSystem(JSONObject mainSystemBeanJson) {
		MainSystemBean mainSystemBean;
		String status = null;
		try {
			mainSystemBean = com.archutils.System.objectMapper.readValue(mainSystemBeanJson.toString(), MainSystemBean.class);
			mainSystemBean.setCreated(new Date().getTime());
			status = mainSystemProxy.saveMainSystem(mainSystemBean);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return status;
	}

}
