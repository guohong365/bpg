package com.uc.bpg.persistence;

import com.uc.web.persistence.AppMapper;
import com.uc.web.persistence.AppOptimizedMapper;

public interface DeviceTypeMapper extends AppMapper, AppOptimizedMapper{

	Long selectNextOrder();
}
