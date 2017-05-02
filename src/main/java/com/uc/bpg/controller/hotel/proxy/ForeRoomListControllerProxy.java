package com.uc.bpg.controller.hotel.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.Room;
import com.uc.bpg.forms.RoomQueryForm;
import com.uc.web.controller.ListController;
import com.uc.web.controller.basic.AbstractIntegerKeyListControllerProxy;

@Controller
@RequestMapping("${controller.proxy.uri.hotel.room}")
public class ForeRoomListControllerProxy extends AbstractIntegerKeyListControllerProxy<RoomQueryForm, Room> {

	@Value("${controller.proxy.uri.hotel.room}")
	private String baseUri;

	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}
	
	@Resource(name="${controller.impl.list.hotel.room}")
	@Override
	public void setListController(ListController<Long, RoomQueryForm, Room> listController) {
		super.setListController(listController);
	}
}
