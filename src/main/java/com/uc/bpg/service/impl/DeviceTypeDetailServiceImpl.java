package com.uc.bpg.service.impl;

import com.uc.bpg.domain.DeviceType;
import com.uc.bpg.persistence.DeviceTypeMapper;
import com.uc.bpg.service.DeviceTypeService;
import com.uc.web.service.basic.GenericIntegerKeyAppDetailService;

public class DeviceTypeDetailServiceImpl extends GenericIntegerKeyAppDetailService<DeviceType> implements DeviceTypeService {

	DeviceTypeMapper getDeviceTypeMapper(){
		return (DeviceTypeMapper) getAppDetailMapper();
	}
	
	@Override
	public Long selectNextShowOrder() {		
		return getDeviceTypeMapper().selectNextOrder();
	}

}
