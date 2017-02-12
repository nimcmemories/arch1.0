package com.application.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.application.bean.MainSystemBean;
import com.application.dao.MainSystemProxy;
import com.bean.dao.AbstractDAO;
@Transactional
public class MainSystemProxyImpl extends AbstractDAO implements MainSystemProxy{

	@SuppressWarnings("unchecked")
	@Override
	public List<MainSystemBean> getMainSystemList() {
		return getSession().createCriteria(MainSystemBean.class).list();
	}

	@Override
	public String saveMainSystem(MainSystemBean mainSystemBean) {
		try{
			getSession().saveOrUpdate(mainSystemBean);
			return "success";
		}catch(Exception e){
			return "failed";
		}
	}

}
