package com.uc.bpg.service.impl;

import org.springframework.util.StringUtils;

import com.uc.bpg.forms.RoleQueryForm;
import com.uc.bpg.service.BusinessListServiceBase;
import com.uc.bpg.service.RoleListService;
import com.uc.web.forms.ListQueryForm;

public class RoleListServiceImpl extends BusinessListServiceBase<RoleQueryForm> implements RoleListService{

	@Override
	public boolean prepareQueryForm(ListQueryForm query) {
		RoleQueryForm queryForm=(RoleQueryForm) query;
		if(StringUtils.isEmpty(queryForm.getQueryName())){
			queryForm.setQueryName(null);
		} 
		queryForm.setQueryAll(queryForm.getQueryAll()!=null && queryForm.getQueryAll());
		return true;
	}
}
