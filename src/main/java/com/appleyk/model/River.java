package com.appleyk.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class River extends BaseEntity{

	private Long id;
	private int num;
	private String label;
	private String region;

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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public River(){
    	
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
}
