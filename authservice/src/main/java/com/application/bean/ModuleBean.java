package com.application.bean;

import org.codehaus.jackson.annotate.JsonIgnore;


/*
 * Represents independent systems to be incorporated with this arch 
 */
public class ModuleBean extends BaseBean {
	private Integer id,parent_module_id;
	private String modified_by,created_by,module_name;
	private Long modified,created;
	@JsonIgnore
	private MainSystemBean mainSystem;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParent_module_id() {
		return parent_module_id;
	}
	public void setParent_module_id(Integer parent_module_id) {
		this.parent_module_id = parent_module_id;
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
	public String getModule_name() {
		return module_name;
	}
	public void setModule_name(String module_name) {
		this.module_name = module_name;
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
	public MainSystemBean getMainSystem() {
		return mainSystem;
	}
	public void setMainSystem(MainSystemBean mainSystem) {
		this.mainSystem = mainSystem;
	}
	
}
