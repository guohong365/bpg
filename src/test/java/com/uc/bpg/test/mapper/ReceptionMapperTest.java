package com.uc.bpg.test.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.uc.bpg.domain.CheckIn;
import com.uc.bpg.domain.RoomDetail;
import com.uc.bpg.persistence.ReceptionMapper;
import com.uc.bpg.test.TestBase;

public class ReceptionMapperTest extends TestBase{
	
	@Autowired
	ReceptionMapper mapper;
	
	@Test
	public void test(){
		List<RoomDetail> list= mapper.selectRoomDetails(2L);
		
		for(RoomDetail detail:list){
			StringBuilder builder=new StringBuilder();
			builder
			.append("ID=").append(detail.getId()).append("\r\n")
			.append("Room No=").append(detail.getRoomNo()).append("\r\n")
			.append("use Times=").append(detail.getUseTimes()).append("\r\n")
			.append("charge=").append(detail.getCharge()).append("\r\n")
			.append("checkIn time=").append(detail.getCheckInTime()).append("\r\n")
			.append("checkOut time=").append(detail.getCheckOutTime()).append("\r\n");
			
			System.err.println(builder.toString());
		}
		
		CheckIn checkIn=mapper.selectRoomCheckIn(2L, "8301");
		
		System.err.println(checkIn.toString());
	}
}
