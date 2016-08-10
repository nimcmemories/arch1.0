package com.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.BaseBean;
import com.model.TestDao;

@RestController
public class AuthHandler {
	@Autowired
	TestDao testDao;
	
	@RequestMapping(value="/ok",method = RequestMethod.GET)
	public String isOk(){
		BaseBean bb = testDao.getTestObj();
		System.out.println(" my name is : " + bb.getName());
		return "Arc1.0 Auth Service working OK.";
	}
}
