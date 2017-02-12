package com.persistence.dao.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.persistence.AbstractDAO;
import com.persistence.dao.bean.TestBean;
import com.persistence.dao.proxy.Test;

@Repository("TestDao")
@Transactional
public class TestImpl extends AbstractDAO implements Test{

	@Override
	public String getResultOutOfMethod() {
		Criteria criteria = getSession().createCriteria(TestBean.class);
		TestBean aclCategory = (TestBean) criteria.list().get(0);
		System.out.println(aclCategory.getName());
		return "I am a response from TestImpl.getResultOutOfMethod";
	}
	
}
