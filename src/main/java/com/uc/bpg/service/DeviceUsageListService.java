package com.uc.bpg.service;

import com.uc.bpg.domain.DeviceUsage;
import com.uc.bpg.forms.DeviceUsageQueryForm;
import com.uc.web.service.basic.IntegerKeyAppListService;

public interface DeviceUsageListService extends IntegerKeyAppListService<DeviceUsageQueryForm, DeviceUsage> {
}
