package com.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apicaller.AuthAPICaller;

/**
 * 
 * @author nimesh
 *
 */
@Controller
public class MVCHandler {

	
	/*
	 * This method is responsible to check number of URLS available in
	 * particular application. To help in maintaining architecture free from
	 * tightly binded ACL structure with main application
	 */
	@RequestMapping(value = "/endpointdoc", method = RequestMethod.GET)
	public void show(Model model) {
		
		System.out.println("model values ; " + model.asMap().toString());
	}

	@RequestMapping(value = "/ok", method = RequestMethod.POST)
	public @ResponseBody String isOk() {
		System.out.println("blank value of auth for this request : " );
		return "{\"status\":\"ok\"}";

	}
	
	
	/**
	 * @return response json includes status and other messages
	 */
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public @ResponseBody String authenticate(@RequestParam("formData") String data) {
		System.out.println("blank value of auth for this request : " + data);
		//AuthAPICaller.authenticateUser(data);
		return "{\"status\":\"ok\"}";
	}
	
}
