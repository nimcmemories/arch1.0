package com.model;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.BaseBean;

public class TestImp implements TestDao{

	 @Autowired
	 SessionFactory sessionFactory;
	 Session session = null;
	 org.hibernate.Transaction tx = null;

	@Override
	public BaseBean getTestObj() {
		Long id =0l;
		System.out.println(" method called ");
		 session = sessionFactory.openSession();
		  BaseBean employee = (BaseBean) session.load(BaseBean.class,
		    new Long(id));
		  tx = session.getTransaction();
		  session.beginTransaction();
		  tx.commit();
		  return employee;
	}
	
}
