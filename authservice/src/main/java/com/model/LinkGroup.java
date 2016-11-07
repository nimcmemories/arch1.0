package com.model;

import com.bean.BaseBean;

public class LinkGroup extends BaseBean {
	private Long linkGroupId;
	private MainSystem mainSystem;
	public Long  getLinkGroupId() {
		return linkGroupId;
	}
	public void setLinkGroupId(Long  linkGroupId) {
		this.linkGroupId = linkGroupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MainSystem getMainSystem() {
		return mainSystem;
	}
	public void setMainSystem(MainSystem mainSystem) {
		this.mainSystem = mainSystem;
	}
	private String name;
	
}
