package com.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AclCategoryService;

@RestController
public class AuthHandler {
	@Autowired
	AclCategoryService aclCategoryService;
	
	@RequestMapping(value="/ok",method = RequestMethod.GET)
	public String isOk(){
		aclCategoryService.getAclCategory();
		return "Arc1.0 Auth Service working OK.";
	}
}
