package com.uc.bpg.test.eval;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.uc.bpg.domain.CheckIn;
import com.uc.bpg.domain.Device;
import com.uc.bpg.domain.Hotel;
import com.uc.bpg.domain.UserImpl;
import com.uc.bpg.forms.HotelQueryForm;
import com.uc.bpg.forms.UserQueryForm;
import com.uc.bpg.persistence.CheckInMapper;
import com.uc.bpg.persistence.DeviceMapper;
import com.uc.bpg.persistence.HotelMapper;
import com.uc.bpg.persistence.UserMapper;
import com.uc.bpg.test.TestBase;

public class CheckInAllRoom extends TestBase {
	
	@Autowired
	CheckInMapper checkInMapper;
	
	@Autowired
	DeviceMapper deviceMapper;
	
	@Autowired
	HotelMapper hotelMapper;
	
	@Autowired
	UserMapper userMapper;
	
		
	@SuppressWarnings("unused")
	private Hotel findHotel(List<Hotel> hotels, Long id){
		for(Hotel hotel: hotels){
			if(hotel.getId().equals(id)){
				return hotel;
			}
		}
		return null;
	}
	
	private UserImpl findUser(List<?> userImpls, Long orgId){
		for(Object user: userImpls){
			if(((UserImpl)user).getOrg().equals(orgId)){
				return (UserImpl) user;
			}
		}
		return null;
	}
	
	@SuppressWarnings({ "unused" })
	@Test
	public void test1(){
		HotelQueryForm queryForm=new HotelQueryForm();
		List<Device> devices=(List<Device>) deviceMapper.selectAllocatedDevices(null);
		
		assertNotNull(devices);
		queryForm.setQueryAll(false);		
		List<?> hotels=hotelMapper.selectOptimized(queryForm, 0, 1000);
		
		UserQueryForm userQueryForm=new UserQueryForm();
		userQueryForm.setQueryAll(false);		
		List<?> userImpls = userMapper.selectOptimized(userQueryForm, 0,  1000);
		
		for(Device device:devices){
			//Hotel hotel=findHotel(hotels, device.getHotel());
			UserImpl userImpl=findUser(userImpls, device.getHotel());
			assertNotNull(userImpl);
			
			CheckIn detail=new CheckIn();
			detail.setCheckInReceptionist(userImpl.getId());
			detail.setCheckInTime(new Date());
			detail.setHotel(device.getHotel());
			detail.setRoom(device.getRoom());
			detail.setUuid(UUID.randomUUID().toString());			
			checkInMapper.insertDetail(detail);
		}
		
	}
	
	
}
