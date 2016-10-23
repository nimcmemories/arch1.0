package com.handlers;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.service.AclDAOService;
import com.bean.service.AclDAOServiceImpl;
import com.bean.service.RoleDAOService;
import com.bean.service.UserDAOService;
import com.model.ACLinkListModel;
import com.model.ACListModel;
import com.model.UserModel;

@RestController
public class AuthHandler {
	private AclDAOService aclDAOServiceImpl;
	private RoleDAOService roleDAOServiceImpl;
	private UserDAOService userDAOServiceImpl;
	 
	

	@RequestMapping(value="/ok",method = RequestMethod.GET)
	public String isOk(){
		System.out.println(" role dao : " + roleDAOServiceImpl.getServiceRoleModel().getName());
		aclDAOServiceImpl.getAcl();
		return "Arc1.0 Auth Service working OK.";
	}
	
	@RequestMapping(value="/auth",method = RequestMethod.POST)
	public String getAuthAndACLList(@RequestBody JSONObject formData){
		
		System.out.println(" getAuthAndACLList : call from alien API  " + formData.toString());
		UserModel userModel;
		JSONObject responseJSON = new JSONObject();
		try{
			String username = (String) formData.get("username");
			String password = (String) formData.get("password");
			userModel = userDAOServiceImpl.getUserModel(username, password);
			if(userModel == null){
				responseJSON.put("responseInfo","Guest");
				responseJSON.put("status",411);
				responseJSON.put("statusDescription","User is not authorized");
			}else{
				JSONObject userInfo = new JSONObject();
				userInfo.put("userACL", ACListModel.getJsonObjectFromList(userModel.getAcListModel()));
				userInfo.put("userLinkACL", ACLinkListModel.getJsonObjectFromList(userModel.getRoleModel().getLinkModel()));
				responseJSON.put("responseInfo", userInfo);
				responseJSON.put("status", 200);
			}
			System.out.println(" ~~~~~~~~~~~ userModel toString value: " + userModel);
		}catch(Exception e){
			e.printStackTrace();
			return new JSONObject().put("status", 411)
								   .put("statusDescription","User is not authorized").toString();
		}
		return responseJSON.toString();
	}


	public void setUserDAOServiceImpl(UserDAOService userDAOServiceImpl) {
		this.userDAOServiceImpl = userDAOServiceImpl;
	}

	public void setRoleDAOServiceImpl(RoleDAOService roleDAOServiceImpl) {
		this.roleDAOServiceImpl = roleDAOServiceImpl;
	}

	public void setAclDAOServiceImpl(AclDAOServiceImpl aclDAOServiceImpl) {
		this.aclDAOServiceImpl = aclDAOServiceImpl;
	}
}
