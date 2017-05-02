package com.uc.bpg.domain;

import com.uc.web.domain.security.basic.IntegerRoleFunctionDefine;

public class RoleFunctionDefine extends IntegerRoleFunctionDefine {
	private Long roleId;
	private Long functionId;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getFunctionId() {
		return functionId;
	}
	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}
	
	
}