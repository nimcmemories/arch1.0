package com.handlers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthHandler {
	@Autowired
	HttpSession httpSession;
	
	@RequestMapping(value="/ok",method = RequestMethod.GET)
	public String isOk(){
		System.out.println("is session new : " +httpSession.isNew());
		return "Arc1.0 MVC OK.";
		
	}
}
