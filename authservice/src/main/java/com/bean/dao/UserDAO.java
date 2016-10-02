package com.bean.dao;

import com.model.UserModel;

public interface UserDAO {
	public UserModel getUserModel(String username,String password);
}
