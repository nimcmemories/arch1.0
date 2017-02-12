package com.application.dao;

import java.util.List;

import com.application.bean.MainSystemBean;

public interface MainSystemProxy {
	public List<MainSystemBean> getMainSystemList();
	public String saveMainSystem(MainSystemBean mainSystemBean);
}
