package com.uc.bpg.service.impl;

import org.springframework.util.StringUtils;

import com.uc.bpg.forms.DeviceUsageQueryForm;
import com.uc.bpg.service.BusinessListServiceBase;
import com.uc.bpg.service.DeviceUsageListService;
import com.uc.web.forms.ListQueryForm;

public class DeviceUsageListServiceImpl extends BusinessListServiceBase<DeviceUsageQueryForm>
	implements DeviceUsageListService{
	@Override
	public boolean prepareQueryForm(ListQueryForm query) {
		super.prepareQueryForm(query);
		DeviceUsageQueryForm queryForm=(DeviceUsageQueryForm) query;
		if(StringUtils.isEmpty(queryForm.getQueryHotelName())){
			queryForm.setQueryHotelName(null);
		}
		queryForm.setQueryPayed(queryForm.getQueryPayed()!=null && queryForm.getQueryPayed());
		queryForm.setQueryInBill(queryForm.getQueryInBill()!=null && queryForm.getQueryInBill());
		if(StringUtils.isEmpty(queryForm.getQueryRoomNo())) {
			queryForm.setQueryRoomNo(null);
		}		
		return true;
	}

}
