package com.system.hospital.bean;

public class TestBean extends BaseBean{
	private String name = "";
	private Integer integer ;
	
	public String getName() {
		System.out.println(" accessing name : " + this.name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer integer) {
		this.integer = integer;
	}
}
