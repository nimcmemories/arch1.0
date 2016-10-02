package com.bean.service;

import com.model.UserModel;

public interface UserDAOService {
	public UserModel getUserModel(String username,String password);
}
