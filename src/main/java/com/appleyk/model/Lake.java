package com.appleyk.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Lake extends BaseEntity{

	private Long id;
	private int num;
	private String location;
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String loc) {
		this.location = location;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Lake(){

	}


	
}
