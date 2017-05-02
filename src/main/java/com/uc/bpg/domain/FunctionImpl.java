package com.uc.bpg.domain;

import com.uc.web.domain.AbstractFunction;

public class FunctionImpl extends AbstractFunction<Long>  {
	private String uuid;
	private String description;
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