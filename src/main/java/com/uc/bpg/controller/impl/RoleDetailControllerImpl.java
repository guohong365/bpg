package com.uc.bpg.controller.impl;

import java.util.List;
import java.util.UUID;

import com.uc.bpg.controller.BusinessDetailControllerBase;
import com.uc.bpg.domain.FunctionAvailable;
import com.uc.bpg.domain.Role;
import com.uc.bpg.service.RoleService;

public class RoleDetailControllerImpl extends BusinessDetailControllerBase<Role>{

	protected RoleService getRoleService(){
		return (RoleService)getAppDetailService();
	}

	@Override
	protected Role onCreateNewDetail() {
		Role detail=new Role();
		detail.setInternal(false);
		detail.setValid(true);
		List<FunctionAvailable> functions=getRoleService().seletctFunctions();
		detail.setFunctions(functions);
		return detail;
	}
	
	@Override
	protected void saveNew(Role detail) {
		detail.setUuid(UUID.randomUUID().toString());
		detail.setInternal(false);
		super.saveNew(detail);
	}
	
	protected void enableRole(Long id, boolean enabled){
		Role detail=new Role();
		detail.setId(id);
		detail.setValid(enabled);
		getAppDetailService().updateSelective(detail);
	}
	@Override
	protected void saveCancelate(Role detail) {
		enableRole(detail.getId(), false);
	}
	
	@Override
	protected void saveReactive(Role detail) {
		enableRole(detail.getId(), true);
	}
	@Override
	protected void saveDisable(Role detail) {
		enableRole(detail.getId(), false);
	}
	@Override
	protected void saveDelete(Role detail) {
	}	
	
}
