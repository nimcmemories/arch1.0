package com.model;

import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bean.BaseBean;

/**
 * This model is to be mapped with t_linkacl type table, which has all the 
 * events mapped to appropriate role
 * 
 * @author nimesh
 *
 */
public class ACLinkListModel extends BaseBean {
	private Long roleId,linkId,linkAclId;
	private int accessType;
	
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	public int getAccessType() {
		return accessType;
	}

	public void setAccessType(int accessType) {
		this.accessType = accessType;
	}

	public Long getLinkId() {
		return linkId;
	}

	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}

	public Long getLinkAclId() {
		return linkAclId;
	}

	public void setLinkAclId(Long linkAclId) {
		this.linkAclId = linkAclId;
	}
	
	@Override
	public String toString(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("roleId", roleId);
		jsonObject.put("linkId", linkId);
		jsonObject.put("linkAclId", linkAclId);
		jsonObject.put("accessType", accessType);
		return jsonObject.toString();
	}
	public static JSONArray getJsonObjectFromList(Set<LinkModel> acLinkListModel){
		JSONArray jsonObject = new JSONArray();
		for(LinkModel acList : acLinkListModel){
			jsonObject.put(new JSONObject(acList.toString()));
		}
		return jsonObject;
	}
	
}
