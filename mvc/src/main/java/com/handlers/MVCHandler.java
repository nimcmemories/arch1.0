package com.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.persistence.service.proxy.TestDAOService;

/**
 * @author nimesh
 *
 */
@Controller
public class MVCHandler {
	@Autowired
	private TestDAOService testDAOServiceObj;
	
	
	public TestDAOService getTestDAOServiceObj() {
		return testDAOServiceObj;
	}

	public void setTestDAOServiceObj(TestDAOService testDAOServiceObj) {
		this.testDAOServiceObj = testDAOServiceObj;
	}

	
	/*
	 * This method is responsible to check number of URLS available in
	 * particular application. To help in maintaining architecture free from
	 * tightly binded ACL structure with main application
	 */
	@RequestMapping(value = "/endpointdoc", method = RequestMethod.GET)
	public void show(Model model) {
		
		System.out.println("model values ; " + model.asMap().toString());
	}

	@RequestMapping(value = "/ok", method = RequestMethod.GET)
	public String isOk() {
		
		System.out.println("is session new : "  + testDAOServiceObj.getResult());
		return "Arc1.0 MVC OK.";

	}
}
