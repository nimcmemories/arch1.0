package com.management.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

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
		
		RestTemplate restTemplate = new RestTemplate();
		//ResponseEntity<String> str= restTemplate.getForEntity("http://localhost:8080/authservice/ok", String.class);
		//System.out.println(" response from rest : " + str);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("destroy filter method..");
	}
	
}
