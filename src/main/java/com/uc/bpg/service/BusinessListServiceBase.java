package com.uc.bpg.service;

import com.uc.bpg.Constant;
import com.uc.bpg.forms.IQueryFormBase;
import com.uc.web.persistence.Example;
import com.uc.web.service.basic.GenericIntegerKeyAppListService;

public class BusinessListServiceBase<QueryFormType extends IQueryFormBase, DetailType> 
	extends GenericIntegerKeyAppListService<QueryFormType, DetailType> {

	@Override
	public boolean prepareExample(QueryFormType queryForm, Example example) {
		Object limit=queryForm.getLimits(Constant.LIMIT_NAME_HOTEL);
		if(limit!=null){
			queryForm.setQueryHotel(Long.parseLong(limit.toString()));
		}
		return true;
	}

}
