package com.uc.bpg.persistence;

import com.uc.bpg.domain.DeviceType;
import com.uc.bpg.forms.DeviceTypeQueryForm;
import com.uc.web.persistence.AppMapper;
import com.uc.web.persistence.AppOptimizedMapper;

public interface DeviceTypeMapper 
	extends AppMapper<Long, DeviceType>, AppOptimizedMapper<DeviceTypeQueryForm, DeviceType>{

	Long selectNextOrder();
}
