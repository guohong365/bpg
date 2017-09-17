package com.uc.bpg.domain;

import com.uc.web.domain.AbstractRoleFunctions;


public class RoleFunctionDefineImpl extends AbstractRoleFunctions {
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
	
	@Override
	public RoleImpl getRole() {
		return (RoleImpl) super.getRole();
	}
	
}