package com.uc.bpg.controller.impl;

import com.uc.bpg.controller.BusinessListControllerBase;
import com.uc.bpg.controller.DeviceUsageRecordListController;
import com.uc.bpg.domain.DeviceUsage;
import com.uc.bpg.forms.DeviceUsageQueryForm;

public class DeviceUsageRecordListControllerImpl 
	extends BusinessListControllerBase<DeviceUsageQueryForm, DeviceUsage> 
	implements DeviceUsageRecordListController{

	@Override
	protected DeviceUsageQueryForm onCreateNewQueryForm() {
		return new DeviceUsageQueryForm();
	}

}
