package com.uc.bpg.service.impl;

import java.util.List;

import com.uc.bpg.domain.Bill;
import com.uc.bpg.domain.DeviceUsage;
import com.uc.bpg.domain.Hotel;
import com.uc.bpg.forms.DeviceUsageQueryForm;
import com.uc.bpg.forms.HotelQueryForm;
import com.uc.bpg.persistence.BillMapper;
import com.uc.bpg.persistence.DeviceUsageMapper;
import com.uc.bpg.persistence.HotelMapper;
import com.uc.bpg.service.BillGeneratorSevice;
import com.uc.web.service.ServiceBase;

public class BillGeneratorServiceImpl extends ServiceBase implements BillGeneratorSevice{
	private BillMapper billMapper;
	private HotelMapper hotelMapper;
	private DeviceUsageMapper usageMapper;
	
	public void setBillMapper(BillMapper billMapper) {
		this.billMapper = billMapper;
	}
	
	public BillMapper getBillMapper() {
		return billMapper;
	}
	
	public void setHotelMapper(HotelMapper hotelMapper) {
		this.hotelMapper = hotelMapper;
	}
	
	public HotelMapper getHotelMapper() {
		return hotelMapper;
	}
	
	public DeviceUsageMapper getUsageMapper() {
		return usageMapper;
	}
	public void setUsageMapper(DeviceUsageMapper usageMapper) {
		this.usageMapper = usageMapper;
	}
	@SuppressWarnings("unchecked")
	@Override
	public
	List<Hotel> selectHotels(){
		HotelQueryForm hotelQueryForm=new HotelQueryForm();
		hotelQueryForm.setQueryAll(false);
		hotelQueryForm.setQueryOwnedDeviceFrom(1);
		long count=getHotelMapper().selectCountOptimized(hotelQueryForm);
		return (List<Hotel>) getHotelMapper().selectOptimized(hotelQueryForm, 0, count);
	}
	@SuppressWarnings("unchecked")
	@Override
	public
	List<DeviceUsage> selectUnbilledUsage(Long hotel){
		DeviceUsageQueryForm usageQueryForm=new DeviceUsageQueryForm();
		usageQueryForm.setQueryHotel(hotel);
		usageQueryForm.setQueryInBill(false);
		
		long count=getUsageMapper().selectCountOptimized(usageQueryForm);
		return (List<DeviceUsage>) getUsageMapper().selectOptimized(usageQueryForm, 0, count);
	}
	@Override
	public
	void insertGeneratedBill(Bill bill, List<DeviceUsage> usages){
		getBillMapper().insertGeneratedBill(bill, usages);
		
		
	}
}
