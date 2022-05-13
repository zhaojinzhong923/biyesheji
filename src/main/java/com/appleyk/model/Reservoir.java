package com.appleyk.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Reservoir extends BaseEntity{

	private Long id;
	private int num;
	private String location;
	private String label;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reservoir(){

	}


	
}
