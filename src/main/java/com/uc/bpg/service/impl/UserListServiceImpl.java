package com.uc.bpg.service.impl;

import org.springframework.util.StringUtils;

import com.uc.bpg.forms.UserQueryForm;
import com.uc.bpg.service.BusinessListServiceBase;
import com.uc.bpg.service.UserListService;
import com.uc.web.forms.ListQueryForm;

public class UserListServiceImpl extends BusinessListServiceBase<UserQueryForm> implements UserListService{

	@Override
	public boolean prepareQueryForm(ListQueryForm query) {
		UserQueryForm queryForm=(UserQueryForm) query;
		if(StringUtils.isEmpty(queryForm.getQueryLoginId())){
			queryForm.setQueryLoginId(null);
		}
		
		if(StringUtils.isEmpty(queryForm.getQueryName())){
			queryForm.setQueryName(null);
		}
		if(StringUtils.isEmpty(queryForm.getQueryOrgName())){
			queryForm.setQueryOrgName(null);
		}
		if(StringUtils.isEmpty(queryForm.getQueryOrgType())){
			queryForm.setQueryOrgType(null);
		}
		queryForm.setQueryAll(queryForm.getQueryAll()!=null && queryForm.getQueryAll());
		if(StringUtils.isEmpty(queryForm.getQueryOrderBy())){
			queryForm.setQueryOrderBy("LOGIN_ID");
			queryForm.setQueryOrder("ASC");
		} 		
		return true;
	}
}
