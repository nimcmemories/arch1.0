package com.model;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonProperty;
import org.json.JSONObject;

import com.bean.AclCategory;
import com.bean.AclEvents;
import com.bean.BaseBean;

/**
 * 
 * System wide all links ( specifically Tableau links ).
 * 
 * @author nimesh
 *
 */
public class LinkModel extends BaseBean {
	private Long linkId;
	private String name;
	
	private Set<EventModel> eventModel;
	private ACLinkListModel aclLinkListModel;
	private LinkGroup setLinkGroup;
	public LinkModel(){
		
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
	public Long getLinkId() {
		return linkId;
	}
	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}
	public Set<EventModel> getEventModel() {
		return eventModel;
	}
	public void setEventModel(Set<EventModel> eventModel) {
		this.eventModel = eventModel;
	}
	public ACLinkListModel getAclLinkListModel() {
		return aclLinkListModel;
	}
	public LinkGroup getSetLinkGroup() {
		return setLinkGroup;
	}
	public void setSetLinkGroup(LinkGroup setLinkGroup) {
		this.setLinkGroup = setLinkGroup;
	}
	
}
