package com.uc.bpg.controller.impl;

import java.util.List;
import java.util.Map;

import com.uc.bpg.controller.BusinessListControllerBase;
import com.uc.bpg.controller.IDeviceController;
import com.uc.bpg.domain.Device;
import com.uc.bpg.forms.DeviceQueryForm;
import com.uc.bpg.service.CodesService;
import com.uc.web.domain.Code;
import com.uc.web.domain.security.UserProfile;

public class DeviceListControllerImpl extends BusinessListControllerBase<DeviceQueryForm, Device> implements IDeviceController{
	
	CodesService codesService;
	
	public CodesService getCodesService() {
		return codesService;
	}
	
	public void setCodesService(CodesService codesService) {
		this.codesService = codesService;
	}
	
	@Override
	protected Map<String, List<? extends Code<Long>>> onGetListPageCodes(UserProfile<Long> user) {
		Map<String, List<? extends Code<Long>>> map= super.onGetListPageCodes(user);
		map.put(CODE_TYPE_NAME, getCodesService().selectTypes(true));
		return map;
	}
	
	@Override
	protected DeviceQueryForm onCreateNewQueryForm() {
		return new DeviceQueryForm();
	}
}
