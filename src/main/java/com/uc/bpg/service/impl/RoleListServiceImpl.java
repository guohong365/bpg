package com.uc.bpg.service.impl;

import org.springframework.util.StringUtils;

import com.uc.bpg.domain.Role;
import com.uc.bpg.forms.RoleQueryForm;
import com.uc.bpg.service.RoleListService;
import com.uc.web.persistence.Example;
import com.uc.web.persistence.QueryCondition;
import com.uc.web.service.AppWebListServiceBase;

public class RoleListServiceImpl extends AppWebListServiceBase<RoleQueryForm, Role> implements RoleListService{

	@Override
	public boolean prepareExample(RoleQueryForm queryForm, Example example) {
		QueryCondition condition= example.or();
		if(StringUtils.isEmpty(queryForm.getQueryName())){
			queryForm.setQueryName(null);
		} else {
			condition.andFieldLike("NAME", queryForm.getQueryName()+"%");			
		}
		if(queryForm.getQueryAll()==null || !queryForm.getQueryAll()){
			condition.andFieldEqualTo("VALID", true);
			queryForm.setQueryAll(false);
		} else {
			queryForm.setQueryAll(true);
		}
		return true;
	}
}
