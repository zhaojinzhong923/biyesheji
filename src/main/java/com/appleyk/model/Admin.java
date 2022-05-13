package com.appleyk.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Admin extends BaseEntity{

	private Long id;
	private int num;

	private String fullName;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Admin(){

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
}
