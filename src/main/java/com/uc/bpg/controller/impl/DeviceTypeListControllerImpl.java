package com.uc.bpg.controller.impl;

import com.uc.bpg.domain.DeviceType;
import com.uc.bpg.forms.DeviceTypeQueryForm;
import com.uc.web.controller.basic.AbstractIntegerKeyListController;

public class DeviceTypeListControllerImpl extends AbstractIntegerKeyListController<DeviceTypeQueryForm, DeviceType> {

	@Override
	protected DeviceTypeQueryForm onCreateNewQueryForm() {
		return new DeviceTypeQueryForm();
	}

}
