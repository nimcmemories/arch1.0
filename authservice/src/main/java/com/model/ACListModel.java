package com.model;

import org.json.JSONObject;

import com.bean.BaseBean;

/**
 * This model is to be mapped with ACList type table, which has all the 
 * events mapped to appropriate role
 * 
 * @author nimesh
 *
 */
public class ACListModel extends BaseBean {
	private Long roleId,aclListId,eventId;
	private String name;
	private String description;
	private int accessRight;
	
	public Long getAclListId() {
		return aclListId;
	}
	public void setAclListId(Long aclListId) {
		this.aclListId = aclListId;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public int getAccessRight() {
		return accessRight;
	}
	public void setAccessRight(int accessRight) {
		this.accessRight = accessRight;
	}
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String toString(){
		return new JSONObject(this).toString();
	}
	
}
