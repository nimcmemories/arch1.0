package com.model;

import java.util.List;

public class UserModel {
	private Long userId;
	private String name,password;
	private RoleModel roleModel;
	private List<ACListModel> acListModel;
	private List<ACLinkListModel> acLinkListModel;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RoleModel getRoleModel() {
		return roleModel;
	}
	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}
	@Override
	public String toString(){
		return "user : " + this.name + " with Role : " + this.roleModel.getName();
	}
	public List<ACListModel> getAcListModel() {
		return acListModel;
	}
	public void setAcListModel(List<ACListModel> acListModel) {
		this.acListModel = acListModel;
	}
	public List<ACLinkListModel> getAcLinkListModel() {
		return acLinkListModel;
	}
	public void setAcLinkListModel(List<ACLinkListModel> acLinkListModel) {
		this.acLinkListModel = acLinkListModel;
	}
}
