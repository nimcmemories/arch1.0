package com.persistence.service.impl;

import org.springframework.stereotype.Service;

import com.persistence.dao.proxy.Test;
import com.persistence.service.proxy.TestDAOService;
@Service("TestDAOService")
public class TestDAOServiceImpl implements TestDAOService {
	Test testDaoImpl;
	public void setTestDaoImpl(Test testDaoImpl) {
		this.testDaoImpl = testDaoImpl;
	}
	@Override
	public String getResult() {
		System.out.println("in getResult method");
		return testDaoImpl.getResultOutOfMethod();
	}
	
}
