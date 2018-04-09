package com.uc.bpg.service;

import com.uc.bpg.forms.IQueryFormBase;
import com.uc.web.service.AppWebListServiceBase;

public class BusinessListServiceBase<QueryFormType extends IQueryFormBase> 
	extends AppWebListServiceBase {
	
//	@Override
//	public boolean prepareQueryForm(ListQueryForm query) {
//		@SuppressWarnings("unchecked")
//		QueryFormType queryForm=(QueryFormType)query;
//		Object limit= ((UserProfileImpl) queryForm.getUser()).getLimits(Constant.LIMIT_NAME_HOTEL);
//		if(limit!=null){
//			queryForm.setQueryHotel(Long.parseLong(limit.toString()));
//		}
//		return true;
//	}

}
