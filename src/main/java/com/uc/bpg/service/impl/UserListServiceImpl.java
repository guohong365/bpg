package com.uc.bpg.service.impl;

import org.springframework.util.StringUtils;

import com.uc.bpg.domain.UserImpl;
import com.uc.bpg.forms.UserQueryForm;
import com.uc.web.persistence.Example;
import com.uc.web.persistence.QueryCondition;
import com.uc.web.service.basic.GenericIntegerKeyAppListService;

public class UserListServiceImpl extends GenericIntegerKeyAppListService<UserQueryForm, UserImpl>{

	@Override
	public boolean prepareExample(UserQueryForm queryForm, Example example) {
		QueryCondition condition=example.or();
		if(StringUtils.isEmpty(queryForm.getQueryLoginId())){
			queryForm.setQueryLoginId(null);
		} else {
			condition.andFieldLike("LOGIN_ID", queryForm.getQueryLoginId()+"%");
		}
		if(StringUtils.isEmpty(queryForm.getQueryName())){
			queryForm.setQueryName(null);
		} else {
			condition.andFieldLike("NAME", queryForm.getQueryName()+"%");
		}
		if(StringUtils.isEmpty(queryForm.getQueryOrgName())){
			queryForm.setQueryOrgName(null);
		} else {
			condition.andFieldLike("ORG_NAME", queryForm.getQueryOrgName()+"%");
		}
		if(StringUtils.isEmpty(queryForm.getQueryOrgType())){
			queryForm.setQueryOrgType(null);
		} else {
			condition.andFieldEqualTo("ORG_TYPE", queryForm.getQueryOrgType());
		}
		if(queryForm.getQueryAll()!=null && queryForm.getQueryAll()){
			queryForm.setQueryAll(true);
		} else {
			queryForm.setQueryAll(false);
			condition.andFieldEqualTo("VALID", true);
		}		
		if(StringUtils.isEmpty(queryForm.getQueryOrderBy())){
			queryForm.setQueryOrderBy("LOGIN_ID");
			queryForm.setQueryOrder("asc");
			example.setOrderByClause(queryForm.getQueryOrderByClause());
		} 		
		return true;
	}
}
