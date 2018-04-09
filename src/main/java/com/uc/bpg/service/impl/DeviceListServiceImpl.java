package com.uc.bpg.service.impl;

import org.springframework.util.StringUtils;

import com.uc.bpg.forms.DeviceQueryForm;
import com.uc.bpg.service.BusinessListServiceBase;
import com.uc.bpg.service.DeviceListService;
import com.uc.utils.IntegerUtils;
import com.uc.web.forms.ListQueryForm;

public class DeviceListServiceImpl extends BusinessListServiceBase<DeviceQueryForm> implements DeviceListService {

	@Override
	public boolean prepareQueryForm(ListQueryForm query) {
		DeviceQueryForm queryForm=(DeviceQueryForm)query;
		super.prepareQueryForm(queryForm);		
		if(IntegerUtils.isEmpty(queryForm.getQueryType())){			
			queryForm.setQueryType(null);
		}
		
		if(IntegerUtils.isEmpty(queryForm.getQueryHotel())){
			queryForm.setQueryHotel(null);
		}
		queryForm.setQueryAll(queryForm.getQueryAll()!=null && queryForm.getQueryAll());
		
		queryForm.setQueryPublicUsage(queryForm.getQueryPublicUsage()!=null && queryForm.getQueryPublicUsage());
		
		if(StringUtils.isEmpty(queryForm.getQueryHotelName())){			
			queryForm.setQueryHotelName(null);
		}
		if(StringUtils.isEmpty(queryForm.getQueryName())){
			queryForm.setQueryName(null);
		}
		
		if(StringUtils.isEmpty(queryForm.getQuerySerialNo())){
			queryForm.setQuerySerialNo(null);
		}
		if(IntegerUtils.isEmpty(queryForm.getQueryStatus())){
			queryForm.setQueryStatus(null);
		}
		return true;
	}
}
