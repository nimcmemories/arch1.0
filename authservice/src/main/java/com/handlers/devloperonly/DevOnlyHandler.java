package com.handlers.devloperonly;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.bean.MainSystemBean;
import com.application.service.MainSystemService;

@RestController
public class DevOnlyHandler {
	 
	@Autowired
	private MainSystemService mainSystemServiceImpl;

	public void setMainSystemServiceImpl(MainSystemService mainSystemServiceImpl) {
		this.mainSystemServiceImpl = mainSystemServiceImpl;
	}

	@RequestMapping(value="/addMainSystem",method = RequestMethod.POST)
	public JSONObject addMainSystem(@RequestBody JSONObject formData){
		System.out.println(" dev only add main system : " + formData.toString());
			mainSystemServiceImpl.dev_saveMainSystem(formData);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ok", "Arc1.0 Auth Service working OK.");
		return jsonObject;
	}
	
	@RequestMapping(value="/addMainSystemTest",method = RequestMethod.GET)
	public String addMainSystem(){
		System.out.println(" test" );
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ok", "Arc1.0 Auth Service working OK.");
		return jsonObject.toString();
	}

}
