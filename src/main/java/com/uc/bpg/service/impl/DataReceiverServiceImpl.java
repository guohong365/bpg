package com.uc.bpg.service.impl;

import java.util.UUID;

import com.uc.bpg.domain.BpData;
import com.uc.bpg.domain.Device;
import com.uc.bpg.domain.DeviceStatus;
import com.uc.bpg.domain.DeviceUsage;
import com.uc.bpg.persistence.DeviceMapper;
import com.uc.bpg.persistence.ReceiverMapper;
import com.uc.bpg.service.DataReceiverService;

public class DataReceiverServiceImpl implements DataReceiverService {

	private DeviceMapper deviceMapper;

	private ReceiverMapper receiverMapper;

	public void setReceiverMapper(ReceiverMapper receiverMapper) {
		this.receiverMapper = receiverMapper;
	}

	public void setDeviceMapper(DeviceMapper deviceMapper) {
		this.deviceMapper = deviceMapper;
	}

	public DeviceMapper getDeviceMapper() {
		return deviceMapper;
	}

	public ReceiverMapper getReceiverMapper() {
		return receiverMapper;
	}

	@Override
	public void insertUsage(String mac, BpData data, DeviceStatus status) {
		Device device = getDeviceMapper().selectBySerial(mac);
		if (device != null) {
			if (status.getStatus() == 0) {
				DeviceUsage usage = new DeviceUsage();
				usage.setDevice(device.getId());
				usage.setDeviceSerial(device.getSerialNo());
				usage.setHotel(device.getHotel());
				usage.setRoom(device.getRoom());
				usage.setUuid(UUID.randomUUID().toString());
				usage.setUseTime(data.getExamineTime());
				data.setDevice(device.getId());
				getReceiverMapper().insetBpData(data);
				getReceiverMapper().insertUsage(usage);
			}
			status.setDevice(device.getId());
			status.setMac(mac);			
			getReceiverMapper().insertStatus(status);
		} else {
			// 系统外设备，抛弃也可以的.....
			// TODO: error logs
		}
	}

	@Override
	public void insertStatus(String mac, DeviceStatus status) {
		Device device = getDeviceMapper().selectBySerial(mac);
		if (device != null) {
			status.setDevice(device.getId());
			getReceiverMapper().insertStatus(status);
		} else {
			// TODO: error logs
		}
	}
}
