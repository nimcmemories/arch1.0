package com.model;

import com.bean.BaseBean;

public class MainSystem extends BaseBean{
	private Long systemId;
	private String name;
	public Long getSystemId() {
		return systemId;
	}
	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
