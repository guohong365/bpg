package com.uc.bpg.test.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.uc.bpg.domain.Room;
import com.uc.bpg.forms.RoomQueryForm;
import com.uc.bpg.service.RoomListService;
import com.uc.bpg.test.TestBase;
import com.uc.web.forms.WebListForm;

public class RoomServiceTest extends TestBase {
	
	@Resource(name="roomListService")
	RoomListService listService;
	
	@Test
	public void test(){
		WebListForm< RoomQueryForm, Room> webForm=new WebListForm<>();
		webForm.setQuery(new RoomQueryForm());
		listService.select(webForm);
	}

}
