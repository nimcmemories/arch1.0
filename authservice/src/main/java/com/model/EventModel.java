package com.model;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonProperty;
import org.json.JSONObject;

import com.bean.AclCategory;
import com.bean.AclEvents;
import com.bean.BaseBean;

/**
 * 
 * System wide all available roles and a set of their accessible roles.
 * 
 * @author nimesh
 *
 */
public class EventModel extends BaseBean {
	private Long aclEventId;
	private String name;
	private Long aclCatId;
	private Set<AclCategory> aclCategory;
	private Set<ACListModel> acListModelSet;
	
	public EventModel() {
	}

	public EventModel(Long aclEventId,String name){
		this.name = name;
		this.setAclEventId(aclEventId);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString(){
		return new JSONObject(this).toString();
	}

	public Long getAclEventId() {
		return aclEventId;
	}

	public void setAclEventId(Long aclEventId) {
		this.aclEventId = aclEventId;
	}

	public Long getAclCatId() {
		return aclCatId;
	}

	public void setAclCatId(Long aclCatId) {
		this.aclCatId = aclCatId;
	}

	public Set<ACListModel> getAcListModelSet() {
		return acListModelSet;
	}

	public void setAcListModelSet(Set<ACListModel> acListModelSet) {
		this.acListModelSet = acListModelSet;
	}

	public Set<AclCategory> getAclCategory() {
		return aclCategory;
	}

	public void setAclCategory(Set<AclCategory> aclCategory) {
		this.aclCategory = aclCategory;
	}

	
}
