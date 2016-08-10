package com;

public class BaseBean {
	private String name1;
	
	private Long id;

	public String getName() {
		System.out.println(" name method called : ....");
		return name1;
	}

	public void setName(String name) {
		this.name1 = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
