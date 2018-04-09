package com.uc.bpg.controller;

import com.uc.bpg.domain.Bill;
import com.uc.bpg.forms.DeviceUsageQueryForm;
import com.uc.web.controller.DetailListController;
import com.uc.web.controller.ExportController;

public interface AccountDetailListController 
	extends 
	DetailListController<Long, Bill, DeviceUsageQueryForm>,  
	ExportController<DeviceUsageQueryForm> {	

}
