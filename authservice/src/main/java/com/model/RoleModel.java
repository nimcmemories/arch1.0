package com.model;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonProperty;
import org.json.JSONObject;

import com.bean.AclEvents;
import com.bean.BaseBean;

/**
 * 
 * System wide all available roles and a set of their accessible roles.
 * 
 * @author nimesh
 *
 */
public class RoleModel extends BaseBean {
	private Long roleId;
	private String name;
	private String description;
	private Set<ACListModel> acListModel;
	private Set<ACLinkListModel> linkAclList;
	
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
	@Override
	public String toString(){
		return new JSONObject(this).toString();
	}

	public Set<ACListModel> getAcListModel() {
		return acListModel;
	}

	public void setAcListModel(Set<ACListModel> acListModel) {
		this.acListModel = acListModel;
	}

	public Set<ACLinkListModel> getLinkAclList() {
		return linkAclList;
	}

	public void setLinkAclList(Set<ACLinkListModel> linkAclList) {
		this.linkAclList = linkAclList;
	}
	
}
