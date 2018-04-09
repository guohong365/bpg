package com.uc.bpg.test.eval;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.uc.bpg.Constant;
import com.uc.bpg.domain.Bill;
import com.uc.bpg.domain.DeviceUsage;
import com.uc.bpg.domain.Hotel;
import com.uc.bpg.forms.DeviceUsageQueryForm;
import com.uc.bpg.forms.HotelQueryForm;
import com.uc.bpg.persistence.BillMapper;
import com.uc.bpg.persistence.DeviceUsageMapper;
import com.uc.bpg.persistence.HotelMapper;
import com.uc.bpg.test.TestBase;

public class GenBill extends TestBase{
	
	@Autowired
	HotelMapper hotelMapper;
	@Autowired
	BillMapper billMapper;
	@Autowired
	DeviceUsageMapper usageMapper;
	
	List<Hotel> hotels;
	@SuppressWarnings("unchecked")
	@Test
	public void test(){
		hotels=(List<Hotel>) hotelMapper.selectOptimized(new HotelQueryForm(), 0, 1000);		
		for(Hotel hotel:hotels){
			DeviceUsageQueryForm usageQueryForm=new DeviceUsageQueryForm();
			usageQueryForm.setQueryHotel(hotel.getId());
			usageQueryForm.setQueryInBill(false);
			Long count=usageMapper.selectCountOptimized(usageQueryForm);
			Bill bill=new Bill();
			bill.setGeneratedTime(new Date());
			bill.setHotel(hotel.getId());
			bill.setUuid(UUID.randomUUID().toString());
			bill.setState(Constant.BILL_STATE_UNPAYED);
			BigDecimal charge=new BigDecimal("0");
			BigDecimal rent=new BigDecimal("0");
			BigDecimal basicCharge=new BigDecimal("0");
			List<DeviceUsage> usages=(List<DeviceUsage>) usageMapper.selectOptimized(usageQueryForm, 0, count);
			for(DeviceUsage usage:usages){
				charge=charge.add(usage.getCharge());
				rent=rent.add(usage.getRent());
				basicCharge= basicCharge.add(usage.getChargeStandard());
			}
			bill.setBasicCharge(basicCharge);
			bill.setIncome(charge);
			bill.setRent(rent);
			billMapper.insertGeneratedBill(bill, usages);			
		}
		
	}
	
}
