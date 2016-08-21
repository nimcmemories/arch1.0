package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class AclCategoryServiceImpl implements AclCategoryService{
	@Autowired
	 SessionFactory sessionFactory;
	 Session session = null;
	 Transaction tx = null;

	@Override
	public void getAclCategory() {
		System.out.println(" method called ");
		 session = sessionFactory.openSession();
		  AclCategory aclCate = (AclCategory) session.load(AclCategory.class,
		    new Long(0l));
		  AclEvents event = aclCate.getSetAclEvents().iterator().next();
		  System.out.println("acl category : " + event.getName());
	}

}
