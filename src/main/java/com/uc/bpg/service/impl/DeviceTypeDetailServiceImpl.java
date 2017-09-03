package com.uc.bpg.service.impl;

import com.uc.bpg.domain.DeviceType;
import com.uc.bpg.persistence.DeviceTypeMapper;
import com.uc.bpg.service.DeviceTypeDetailService;
import com.uc.web.service.AppDetailServiceBase;

public class DeviceTypeDetailServiceImpl extends AppDetailServiceBase<Long, DeviceType> implements DeviceTypeDetailService {

	public DeviceTypeMapper getMapper(){
		return (DeviceTypeMapper) super.getMapper();
	}
	
	@Override
	public Long selectNextShowOrder() {		
		return getMapper().selectNextOrder();
	}

}
