package com.uc.bpg.service.impl;

import org.springframework.util.StringUtils;

import com.uc.bpg.forms.HotelQueryForm;
import com.uc.bpg.service.BusinessListServiceBase;
import com.uc.bpg.service.HotelListService;
import com.uc.utils.IntegerUtils;
import com.uc.web.forms.ListQueryForm;

public class HotelListServiceImpl extends BusinessListServiceBase<HotelQueryForm> implements HotelListService{

	@Override
	public boolean prepareQueryForm(ListQueryForm query) {
		super.prepareQueryForm(query);
		HotelQueryForm queryForm=(HotelQueryForm) query;
		if(StringUtils.isEmpty(queryForm.getQueryName())) {
			queryForm.setQueryName(null);
		}
		if(StringUtils.isEmpty(queryForm.getQueryBillingCycleType())) {
			queryForm.setQueryBillingCycleType(null);
		}
		queryForm.setQueryAll(queryForm.getQueryAll()!=null && queryForm.getQueryAll());
		if(IntegerUtils.isEmpty(queryForm.getQueryPublicUsageFrom())) {
			queryForm.setQueryPublicUsageFrom(null);
		} 
		if(IntegerUtils.isEmpty(queryForm.getQueryPublicUsageTo())){
			queryForm.setQueryPublicUsageTo(null);
		}
		if(IntegerUtils.isEmpty(queryForm.getQueryTotalDeviceFrom())){
			queryForm.setQueryTotalDeviceFrom(null);
		}
		if(IntegerUtils.isEmpty(queryForm.getQueryTotalDeviceTo())){
			queryForm.setQueryTotalDeviceTo(null);
		}
		if(StringUtils.isEmpty(queryForm.getQueryName())){
			queryForm.setQueryName(null);
		}
		if(IntegerUtils.isEmpty(queryForm.getQueryOwnedDeviceFrom())){
			queryForm.setQueryOwnedDeviceFrom(null);
		}
		if(IntegerUtils.isEmpty(queryForm.getQueryOwnedDeviceTo())){
			queryForm.setQueryOwnedDeviceTo(null);
		}
		return true;
	}

}
