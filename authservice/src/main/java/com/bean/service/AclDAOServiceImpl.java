package com.bean.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.dao.AclDAO;
import com.bean.dao.AclDAOImpl;

@Service("AclDAOService")
@Transactional
public class AclDAOServiceImpl implements AclDAOService {

	public void setAclDaoImpl(AclDAO aclDaoImpl) {
		this.aclDaoImpl = aclDaoImpl;
	}

	AclDAO aclDaoImpl;
	
	@Override
	public void getAcl() {
		aclDaoImpl.getAcl();
		System.out.println(" in AclDAOServiceImpl...");
	}

}
