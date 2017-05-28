package com.uc.bpg.test.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.uc.bpg.domain.Charging;
import com.uc.bpg.domain.CheckIn;
import com.uc.bpg.domain.HotelRoomInfo;
import com.uc.bpg.service.ReceptionService;
import com.uc.bpg.test.TestBase;
import com.uc.bpg.uitls.OptResult;

public class ReceptionServiceTest extends TestBase {
	@Resource(name="receptionService")
	ReceptionService service;
	
	@Test
	public void test(){
		HotelRoomInfo info=service.selectHotelRoomInfo(2L);
		
		System.err.println(JSON.toJSON(info));
		
		OptResult<CheckIn> result=service.selectRoomCheckIn(2L, "8301");
		
		System.err.println(result.toString());
		
		OptResult<Charging> chargeResult=service.selectRoomCheckOut(2L, "8301");
		
		System.err.println(chargeResult.toString());
		
	}
}
