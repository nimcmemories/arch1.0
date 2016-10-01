package com.management.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.apicaller.AuthAPICaller;
import com.utils.APIUtils;

/**
 * 
 * Filters all the request against valid ACLs and valid sessions after authentication. 
 * Every request after successful authentication will be validated for valid ACL if not 
 * appropriate redirection/message is given as response
 * @author nimesh
 *
 */
public class SessionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("1 filter init method..");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("do filter method..");
		System.out.println(" is new session from filter check " + SessionValidator.checkSession((HttpServletRequest)request));
		
		
		
		if(!filterRequestForValidSession((HttpServletRequest) request)){
			System.out.println("session not validated hence auth set as failed : ");
			HttpServletResponse res = ((HttpServletResponse) response);
			res.setStatus(409);
			request.setAttribute("auth", "failed");
			return;
		}else{
			
			/*
			 * In this condition user is already validated and now need to check for
			 * ACLs only
			 * 
			 */
			/* HERE ONE NEEDS TO CHECK
			 * CHECK IF THE REQUEST THIS FILTER GOT IS ALLOWED TO USER
			 * EX : /MVC/DO/LISTUSER is this URL allowed to end user ? 
			 * if yes move forward 
			*/
			JSONObject authJson = (JSONObject) ((HttpServletRequest)request).getSession().getAttribute("authJson");
			System.out.println(" we have to response as this is a valid request or not :-" + authJson);
		}
		chain.doFilter(request, response);
	}
	/** 
	 * Method is responsible for session validation and rejection if not a valid user.
	 * @param request
	 * @return
	 */
	private boolean filterRequestForValidSession(HttpServletRequest request){
		System.out.println(" url hit in session filter : " + request.getRequestURI());
		HttpSession session = request.getSession();
		
		
		
		if(SessionValidator.checkSession(request)){
			System.out.println("valid request for login");
			JSONObject formData = new JSONObject(((HttpServletRequest)request).getParameter("formData"));
			System.out.println(" formData from request " +((HttpServletRequest)request).getParameter("formData"));
			String userName = formData.getString("username");
			String password = formData.getString("password");
			if(userName == null || password == null){
				System.out.println("in SessionFitler filterRequestForSession method to check if user and pass are blank");
			}else{
				System.out.println("authenticate user : " + userName);
				JSONObject authJson =  AuthAPICaller.authenticateUser(userName,password);
				if(APIUtils.isExpectedJSON(authJson, "acl")){
					request.setAttribute("authJson", authJson);
					request.getSession().setAttribute("userInfo", authJson);
					return true;
				}
			}
		}else{
			/*
			 * if session does not contain user information then 
			 * invalidate user session
			 */
			if(session.getAttribute("userInfo")!=null){
				System.out.println("userSession is not null and has a valid session with user detail and ACLs");
			/*
			 * controll flow may fall here only when the session is old
			 * and need to check for other ACLs
			 * 
			 */
				return true;
			}
		}
		session.invalidate();
		return false;
	}
	
	
	
	@Override
	public void destroy() {
		System.out.println("destroy filter method..");
	}
	
}
