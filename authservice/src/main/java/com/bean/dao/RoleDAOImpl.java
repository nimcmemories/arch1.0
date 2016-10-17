package com.bean.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;

import com.model.RoleModel;

@Transactional
public class RoleDAOImpl extends AbstractDAO implements RoleDAO{

	@Override
	public RoleModel getRoleModel() {
		Criteria criteria = getSession().createCriteria(RoleModel.class);
		RoleModel roleModel = (RoleModel) criteria.list().get(0);
		Hibernate.initialize(roleModel.getEventModel());
		Hibernate.initialize(roleModel.getLinkModel());
		System.out.println("role accessible link dao impl " + roleModel.getLinkModel().iterator().next().getName());
		return roleModel;
	}

}
