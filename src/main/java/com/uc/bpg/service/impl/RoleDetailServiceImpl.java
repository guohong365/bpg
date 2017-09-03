package com.uc.bpg.service.impl;

import java.util.List;

import com.uc.bpg.domain.FunctionAvailable;
import com.uc.bpg.domain.Role;
import com.uc.bpg.persistence.RoleMapper;
import com.uc.bpg.service.RoleDetailService;
import com.uc.web.service.AppDetailServiceBase;

public class RoleDetailServiceImpl extends AppDetailServiceBase<Long, Role> implements RoleDetailService {
	public RoleMapper getMapper(){
		return (RoleMapper)getMapper();
	}
	
	@Override
	public void onAfterSelected(Role detail) {
		List<FunctionAvailable> functions=getMapper().selectFunctions(detail.getId(), true);
		detail.setFunctions(functions);
	}

	@Override
	public List<FunctionAvailable> seletctFunctions() {
		return getMapper().selectFunctions(null, true);
	}
	
}
