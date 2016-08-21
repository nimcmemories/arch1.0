package com.bean;

import java.util.Set;

public class AclCategory {
	private Long aclCatId;
	private String name;
	private Set<AclEvents> setAclEvents;
	/*
	 * _default stands for if the created row is system default or something which is 
	 * created by users
	 */
	private int _default;
	
	
	public int get_default() {
		return _default;
	}
	public void set_default(int _default) {
		this._default = _default;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAclCatId() {
		return aclCatId;
	}
	public void setAclCatId(Long aclCatId) {
		this.aclCatId = aclCatId;
	}
	public Set<AclEvents> getSetAclEvents() {
		return setAclEvents;
	}
	public void setSetAclEvents(Set<AclEvents> setAclEvents) {
		this.setAclEvents = setAclEvents;
	}
	
	
}
