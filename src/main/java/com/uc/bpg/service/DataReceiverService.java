package com.uc.bpg.service;

import com.uc.bpg.domain.BpData;
import com.uc.bpg.domain.DeviceStatus;

public interface DataReceiverService {
	void insertUsage(String mac, BpData data, DeviceStatus statusDetail);
	void insertStatus(String mac, DeviceStatus detial);
}
