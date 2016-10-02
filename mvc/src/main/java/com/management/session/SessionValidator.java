package com.management.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionValidator {
	public static boolean checkSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.isNew()){
			System.out.println("~~~~ its a new session");
			return true;
		}else{
			System.out.println("~~~~ its an old session");
			return false;
		}
	}
	
	public static void createSessionPostValidation(){
		
	}
}
