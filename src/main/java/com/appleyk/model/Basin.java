package com.appleyk.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Basin extends BaseEntity{

	private Long id;
	private int code;
	private String label;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Basin(){
    	
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
}
