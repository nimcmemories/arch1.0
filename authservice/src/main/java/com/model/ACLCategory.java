package com.model;

import com.bean.BaseBean;

public class ACLCategory extends BaseBean {
	private Long aclCatId;
	private String name;
	private int _default;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString(){
		return "aclcategory return toString";
	}
	public Long getAclCatId() {
		return aclCatId;
	}
	public void setAclCatId(Long aclCatId) {
		this.aclCatId = aclCatId;
	}
	public int get_default() {
		return _default;
	}
	public void set_default(int _default) {
		this._default = _default;
	}
}
