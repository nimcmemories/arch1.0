package com.bean.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.dao.RoleDAO;
import com.model.RoleModel;
@Service("RoleDAOService")
@Transactional
public class RoleDAOServiceImpl implements RoleDAOService{
	
	RoleDAO roleDAOImpl ;

	public void setRoleDAOImpl(RoleDAO roleDAOImpl) {
		System.out.println(" role impl DAO set from spring bean factory");
		this.roleDAOImpl = roleDAOImpl;
	}
	@Override
	public RoleModel getServiceRoleModel() {
		System.out.println(" role get model " + roleDAOImpl.getRoleModel().getName());
		return roleDAOImpl.getRoleModel();
	}

}
