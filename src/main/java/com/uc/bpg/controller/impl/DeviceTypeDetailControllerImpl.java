package com.uc.bpg.controller.impl;

import java.util.UUID;

import com.uc.bpg.controller.BusinessDetailControllerBase;
import com.uc.bpg.domain.DeviceType;
import com.uc.bpg.service.DeviceTypeService;

public class DeviceTypeDetailControllerImpl extends BusinessDetailControllerBase<DeviceType> {

	@Override
	protected DeviceType onCreateNewDetail() {
		DeviceType detail= new DeviceType();
		detail.setValid(true);
		detail.setUuid(UUID.randomUUID().toString());
		return detail;
	}
	
	DeviceTypeService getDeviceTypeService(){
		return (DeviceTypeService) getAppDetailService();
	}
	
	@Override
	protected void saveNew(DeviceType detail) {
		if(detail.getShowOrder()==null){
			Long order= getDeviceTypeService().selectNextShowOrder();
			detail.setShowOrder(order);
		}
		super.saveNew(detail);
	}

}
