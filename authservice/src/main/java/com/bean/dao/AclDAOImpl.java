package com.bean.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.AclCategory;
@Repository("AclDAO")
@Transactional
public class AclDAOImpl extends AbstractDAO implements AclDAO{
	
	@Override
	public void getAcl() {
		Criteria criteria = getSession().createCriteria(AclCategory.class);
		AclCategory aclCategory = (AclCategory) criteria.list().get(0);
		System.out.println(aclCategory.getName());
	}

}
