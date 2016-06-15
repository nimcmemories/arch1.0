package com.handlers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthHandler {
	@RequestMapping(value="/ok",method = RequestMethod.GET)
	public String isOk(){
		return "Arc1.0 Auth Service working OK.";
	}
}
