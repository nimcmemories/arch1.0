package com.handlers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRequestHandler {
	
	@RequestMapping(value="/testRequestHandler",method = RequestMethod.GET)
	public String isOk(){
		return "Arc1.0 TESTHANDLER OK.";
	}
}
