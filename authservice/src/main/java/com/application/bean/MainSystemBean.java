package com.application.bean;

import java.util.Calendar;
import java.util.Set;

/*
 * Represents independent systems to be incorporated with this arch 
 */
public class MainSystemBean extends BaseBean {
	private Integer systemid;
	private String name,modified_by,created_by,description;
	private Long modified,created;
	
	
	private Set<ModuleBean> setModuleBean;
	public MainSystemBean(){
		this.modified = Calendar.getInstance().getTimeInMillis();
		
	}
	public Integer getSystemid() {
		
		return systemid;
	}
	public void setSystemid(Integer systemid) {
		this.systemid = systemid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Long getModified() {
		return modified;
	}
	public void setModified(Long modified) {
		this.modified = modified;
	}
	public Long getCreated() {
		return created;
	}
	public void setCreated(Long created) {
		this.created = created;
	}
	public Set<ModuleBean> getSetModuleBean() {
		return setModuleBean;
	}
	public void setSetModuleBean(Set<ModuleBean> setModuleBean) {
		this.setModuleBean = setModuleBean;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
