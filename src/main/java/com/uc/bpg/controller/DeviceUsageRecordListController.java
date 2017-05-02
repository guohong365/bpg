package com.uc.bpg.controller;

import com.uc.bpg.domain.DeviceUsage;
import com.uc.bpg.forms.DeviceUsageQueryForm;
import com.uc.web.controller.basic.IntegerKeyListController;

public interface DeviceUsageRecordListController extends
	IntegerKeyListController<DeviceUsageQueryForm, DeviceUsage> {

}
