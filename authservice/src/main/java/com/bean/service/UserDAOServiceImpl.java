package com.bean.service;

import com.bean.dao.UserDAO;
import com.model.UserModel;

/**
 * User model holds user specific authentication properties.
 * @author nimesh
 *
 */
public class UserDAOServiceImpl implements UserDAOService{
	
	private UserDAO userDAOImpl;
	
	public void setUserDAOImpl(UserDAO userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}
	
	@Override
	public UserModel getUserModel(String username, String password) {
		return userDAOImpl.getUserModel(username, password);
	}

}
