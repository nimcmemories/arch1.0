package com.model;

import java.util.List;

import org.json.JSONArray;
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
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("roleId", roleId);
		jsonObject.put("aclListId", aclListId);
		jsonObject.put("eventId", eventId);
		jsonObject.put("name", name);
		jsonObject.put("description", description);
		jsonObject.put("accessRight", accessRight);
		return jsonObject.toString();
	}
	public static JSONArray getJsonObjectFromList(List<ACListModel> acListModel){
		JSONArray jsonObject = new JSONArray();
		for(ACListModel acList : acListModel){
			jsonObject.put(new JSONObject(acList.toString()));
		}
		return jsonObject;
	}
	
	
}
