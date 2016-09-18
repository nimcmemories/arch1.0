package com.handlers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.service.AclDAOService;
import com.bean.service.AclDAOServiceImpl;

@RestController
public class AuthHandler {
	AclDAOService aclDAOServiceImpl;


	 
	
	public void setAclDAOServiceImpl(AclDAOServiceImpl aclDAOServiceImpl) {
		this.aclDAOServiceImpl = aclDAOServiceImpl;
	}

	@RequestMapping(value="/ok",method = RequestMethod.GET)
	public String isOk(){
		aclDAOServiceImpl.getAcl();
		return "Arc1.0 Auth Service working OK.";
	}
}
