package com.bean.dao;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import com.model.UserModel;
@Transactional
public class UserDAOImpl extends AbstractDAO implements UserDAO{

	@Override
	public UserModel getUserModel(String username,String password) {
		Query query = getSession().createQuery("from UserModel where "
				+ "user=:username and password=:password" );
		query.setParameter("username",username);
		query.setParameter("password",password);
		UserModel userModel = null;
		try{
		userModel= (UserModel) query.list().get(0);
		Hibernate.initialize(userModel.getRoleModel().getAcListModel());
		System.out.println(" user model retrieved from DB : " + userModel);
		}catch(Exception e){
			e.printStackTrace();
		}
		return userModel;
	}
	
}
