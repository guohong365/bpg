package com.uc.bpg.service.impl;

import java.util.List;

import com.uc.bpg.domain.FunctionAvailable;
import com.uc.bpg.domain.Role;
import com.uc.bpg.persistence.RoleMapper;
import com.uc.bpg.service.RoleService;
import com.uc.web.service.basic.GenericIntegerKeyAppDetailService;

public class RoleDetailServiceImpl extends GenericIntegerKeyAppDetailService<Role> implements RoleService {
	RoleMapper getRoleMapper(){
		return (RoleMapper)getAppDetailMapper();
	}
	
	@Override
	public void onAfterSelected(Role detail) {
		List<FunctionAvailable> functions=getRoleMapper().selectFunctions(detail.getId(), true);
		detail.setFunctions(functions);
	}

	@Override
	public List<FunctionAvailable> seletctFunctions() {
		return getRoleMapper().selectFunctions(null, true);
	}
	
}
