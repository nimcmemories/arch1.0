package com.handlers;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.service.AclDAOService;
import com.bean.service.AclDAOServiceImpl;
import com.bean.service.RoleDAOService;
import com.model.ACListModel;

@RestController
public class AuthHandler {
	AclDAOService aclDAOServiceImpl;
	RoleDAOService roleDAOServiceImpl;

	 
	
	public void setRoleDAOServiceImpl(RoleDAOService roleDAOServiceImpl) {
		this.roleDAOServiceImpl = roleDAOServiceImpl;
	}

	public void setAclDAOServiceImpl(AclDAOServiceImpl aclDAOServiceImpl) {
		this.aclDAOServiceImpl = aclDAOServiceImpl;
	}

	@RequestMapping(value="/ok",method = RequestMethod.GET)
	public String isOk(){
		System.out.println(" role dao : " + roleDAOServiceImpl.getServiceRoleModel().getName());
		aclDAOServiceImpl.getAcl();
		return "Arc1.0 Auth Service working OK.";
	}
	
	@RequestMapping(value="/auth",method = RequestMethod.POST)
	public JSONObject getAuthAndACLList(@RequestBody JSONObject formData){
		
		System.out.println(" getAuthAndACLList : call from pardesi API  " + formData.toString());
		System.out.println(" role dao : " + roleDAOServiceImpl.getServiceRoleModel().getName());
		ACListModel acListModel = roleDAOServiceImpl.getServiceRoleModel().getAcListModel().iterator().next();
		System.out.println(" value from acListModel" + acListModel.getDescription());
		aclDAOServiceImpl.getAcl();
		JSONObject responseJSON = new JSONObject(roleDAOServiceImpl.getServiceRoleModel());
		responseJSON.put("status", 200);
		return responseJSON;
	}
}
