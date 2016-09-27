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
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
		if(!filterRequestForSession((HttpServletRequest) request)){
			//redirect to login page if session is not validated
			System.out.println("session not valided hence auth set as failed : ");
			HttpServletResponse res = ((HttpServletResponse) response);
			res.setStatus(409);
			request.setAttribute("auth", "failed");
			return;
		}
		chain.doFilter(request, response);
	}
	/** 
	 * Method is responsible for session validation and rejection if not a valid user.
	 */
	private boolean filterRequestForSession(HttpServletRequest request){
		System.out.println(" url hit in session filter : " + request.getRequestURI());
		HttpSession session = request.getSession();
		if(SessionValidator.checkSession(request)){
			String userName = ((HttpServletRequest)request).getParameter("username");
			String password = ((HttpServletRequest)request).getParameter("password");
			if(userName == null || password == null){
				System.out.println("in SessionFitler filterRequestForSession method to check if user and pass are blank");
				session.invalidate();
				return false;
			}else{
				//PENDING CODE HERE: check if service responds with positive or negative for authentication
				RestTemplate restTemplate = new RestTemplate();
				//ResponseEntity<String> str= restTemplate.getForEntity("http://localhost:8080/authservice/ok", String.class);
				//System.out.println(" response from rest : " + str);
				// if positive return true
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
