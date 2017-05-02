package com.uc.bpg.service;

import java.util.List;

import com.uc.bpg.domain.Bill;
import com.uc.bpg.domain.DeviceUsage;
import com.uc.bpg.domain.Hotel;

public interface BillGeneratorSevice {

	List<Hotel> selectHotels();

	List<DeviceUsage> selectUnbilledUsage(Long hotel);

	void insertGeneratedBill(Bill bill, List<DeviceUsage> usages);

}
