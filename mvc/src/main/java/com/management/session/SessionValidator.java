package com.management.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionValidator {
	public static boolean checkSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.isNew()){
			return true;
		}else{
			return false;
		}
	}
	
	public static void createSessionPostValidation(){
		
	}
}
