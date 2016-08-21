package com.bean;

public class AclEvents {
	private Long aclEventId,aclCatId;
	private String name;
	private int _default;
	public int get_default() {
		return _default;
	}
	public void set_default(int _default) {
		this._default = _default;
	}
	public Long getAclCatId() {
		return aclCatId;
	}
	public void setAclCatId(Long aclCatId) {
		this.aclCatId = aclCatId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAclEventId() {
		return aclEventId;
	}
	public void setAclEventId(Long aclEventId) {
		this.aclEventId = aclEventId;
	}
}
