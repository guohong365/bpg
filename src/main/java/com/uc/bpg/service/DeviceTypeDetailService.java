package com.uc.bpg.service;

import com.uc.bpg.domain.DeviceType;
import com.uc.web.service.AppDetailService;

public interface DeviceTypeDetailService extends AppDetailService<Long, DeviceType>{
	Long selectNextShowOrder();
}
