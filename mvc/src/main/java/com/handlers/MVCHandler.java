package com.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
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
	public @ResponseBody String isOk(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		System.out.println("blank value of auth for this request : " );
		return ((JSONObject)session.getAttribute("userInfo")).toString();

	}
	
	
	/**
	 * @return response json includes status and other messages
	 */
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public @ResponseBody String authenticate(@RequestParam("formData") String data,HttpServletRequest request) {
		System.out.println("blank value of auth for this request : " + data);
		System.out.println(" session user info obj from MVCHandler : " + request.getSession().getAttribute("userInfo"));
		
		return "{\"status\":\"ok\"}";
	}
	
}
