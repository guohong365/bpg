package com.uc.bpg.test.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.uc.bpg.domain.Room;
import com.uc.bpg.forms.RoomQueryForm;
import com.uc.bpg.test.TestBase;
import com.uc.web.forms.WebListFormBase;
import com.uc.web.forms.ui.componet.IPageCtrl;
import com.uc.web.service.basic.IntegerKeyAppListService;

public class RoomServiceTest extends TestBase {
	
	@Resource(name="roomListService")
	IntegerKeyAppListService<RoomQueryForm, Room> listService;
	
	@Test
	public void test(){
		WebListFormBase<Long, RoomQueryForm, Room> webForm=new WebListFormBase<>();
		webForm.setQuery(new RoomQueryForm());
		listService.select(webForm);
		
		IPageCtrl pageCtrl=webForm.getPageCtrl();
		pageCtrl.setCurrent(1L);
		listService.select(webForm);
		
	}

}
