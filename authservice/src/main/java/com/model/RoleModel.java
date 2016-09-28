package com.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.json.JSONObject;

import com.bean.BaseBean;

public class RoleModel extends BaseBean {
	private Long roleId;
	private String name;
	private String description;
	
	
	public RoleModel() {
	}

	public RoleModel(Long roleId,String name,String description){
		this.setRoleId(roleId);
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}
	@JsonProperty("Name")
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("Description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonProperty("roleId")
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString(){
		return new JSONObject(this).toString();
	}
	
}
