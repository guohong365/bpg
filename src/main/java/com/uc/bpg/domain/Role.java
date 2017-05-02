package com.uc.bpg.domain;

import java.util.List;

import com.uc.web.domain.basic.IntegerRole;

public class Role extends IntegerRole {
	private String uuid;
	private String description;
	private List<FunctionAvailable> functions;
	
	public List<FunctionAvailable> getFunctions() {
		return functions;
	}
	
	public void setFunctions(List<FunctionAvailable> functions) {
		this.functions = functions;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}