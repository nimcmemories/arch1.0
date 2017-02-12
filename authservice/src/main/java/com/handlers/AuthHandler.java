package com.handlers;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.service.MainSystemService;
import com.bean.service.AclDAOService;
import com.bean.service.AclDAOServiceImpl;
import com.bean.service.RoleDAOService;
import com.bean.service.UserDAOService;
import com.model.UserModel;

@RestController
public class AuthHandler {
	private UserDAOService userDAOServiceImpl;
	 
	@Autowired
	private MainSystemService mainSystemServiceImpl;

	public void setMainSystemServiceImpl(MainSystemService mainSystemServiceImpl) {
		this.mainSystemServiceImpl = mainSystemServiceImpl;
	}

	@RequestMapping(value="/ok",method = RequestMethod.GET)
	public String isOk(){
		System.out.println(" main system json : " + mainSystemServiceImpl.getMainSystemJSON());
		return "Arc1.0 Auth Service working OK.";
	}
	
	@RequestMapping(value="/auth",method = RequestMethod.POST)
	public JSONObject getAuthAndACLList(@RequestBody JSONObject formData){
		
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
				Map<String, Object> userInfo = new HashMap<String,Object>();
				userInfo.put("userACL", userModel.getRoleModel().getEventModel());
				userInfo.put("userLinkACL", userModel.getRoleModel().getLinkModel());
				responseJSON.put("responseInfo", userInfo);
				responseJSON.put("status", 200);
			}
			System.out.println(" ~~~~~~~~~~~ userModel toString value: " + userModel);
		}catch(Exception e){
			e.printStackTrace();
			return new JSONObject().put("status", 411)
								   .put("statusDescription","User is not authorized");
		}
		return responseJSON;
	}

	public void setUserDAOServiceImpl(UserDAOService userDAOServiceImpl) {
		this.userDAOServiceImpl = userDAOServiceImpl;
	}
}
