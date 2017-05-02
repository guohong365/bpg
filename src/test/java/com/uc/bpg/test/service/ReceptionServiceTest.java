package com.uc.bpg.test.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.uc.bpg.domain.HotelRoomInfo;
import com.uc.bpg.service.ReceptionService;
import com.uc.bpg.test.TestBase;

public class ReceptionServiceTest extends TestBase {
	@Resource(name="receptionService")
	ReceptionService service;
	
	@Test
	public void test(){
		HotelRoomInfo info=service.selectHotelRoomInfo(2L);
		
		System.err.println(JSON.toJSON(info));
		
	}
}
