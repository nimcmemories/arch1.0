package com.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthMVCHandler {
	
	public @RequestMapping(value="/okMVC",method = RequestMethod.GET) String getMVCResult(){
		System.out.println("OK MVC called");
		return null;
	}
}
