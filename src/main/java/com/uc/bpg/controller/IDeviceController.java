package com.uc.bpg.controller;

import com.uc.bpg.service.CodesService;

public interface IDeviceController {
	public static final String CODE_TYPE_NAME = "_TYPES";
	public static final String CODE_HOTEL_NAME = "_HOTELS";
	void setCodesService(CodesService codesService);
	CodesService getCodesService();
	
}
