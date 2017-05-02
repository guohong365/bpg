package com.uc.bpg.controller;

import com.uc.bpg.domain.Bill;
import com.uc.bpg.domain.DeviceUsage;
import com.uc.bpg.forms.DeviceUsageQueryForm;
import com.uc.web.controller.basic.IntegerKeyDetailListController;

public interface AccountDetailController extends IntegerKeyDetailListController<Bill, DeviceUsageQueryForm, DeviceUsage> {	

}
