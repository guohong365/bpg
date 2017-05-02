package com.uc.bpg.service.impl;

import org.springframework.util.StringUtils;

import com.uc.bpg.domain.DeviceUsage;
import com.uc.bpg.forms.DeviceUsageQueryForm;
import com.uc.bpg.service.DeviceUsageListService;
import com.uc.web.persistence.Example;
import com.uc.web.persistence.QueryCondition;
import com.uc.web.service.basic.GenericIntegerKeyAppListService;

public class DeviceUsageListServiceImpl extends GenericIntegerKeyAppListService<DeviceUsageQueryForm, DeviceUsage>
	implements DeviceUsageListService{
	
	@Override
	public boolean prepareExample(DeviceUsageQueryForm queryForm, Example example) {
		if(super.prepareExample(queryForm, example)){
			QueryCondition condition= example.or();
			if(queryForm.getQuerySelectedId()!=null){
				condition.andFieldEqualTo("BILL", queryForm.getQuerySelectedId());
			}
			if(!StringUtils.isEmpty(queryForm.getQueryHotelName())){
				condition.andFieldLike("HOTEL_NAME", queryForm.getQueryHotelName() + "%");
			} else {
				queryForm.setQueryHotelName(null);
			}
			if(queryForm.getQueryUseTimeFrom()!=null){
				condition.andFieldGreaterThanOrEqualTo("USE_TIME", queryForm.getQueryUseTimeFrom());
			} 
			if(queryForm.getQueryUseTimeTo()!=null){
				condition.andFieldLessThanOrEqualTo("USE_TIME", queryForm.getQueryUseTimeTo());
			}
			if(queryForm.getQueryPayed()!=null){
				if(queryForm.getQueryPayed()){
					condition.andFieldEqualTo("PAYED", true);
				}else {
					condition.andFieldEqualTo("PAYED", false);
				}
			}			
			return true;
		} else {
			return false;
		}
	}

}
