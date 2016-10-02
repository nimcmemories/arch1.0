package com.model;

public class UserModel {
	private Long userId;
	private String name,password;
	private RoleModel roleModel;
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
}
