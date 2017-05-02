package com.uc.bpg.controller.hotel.impl;

import com.uc.bpg.controller.BusinessListControllerBase;
import com.uc.bpg.controller.RoomListController;
import com.uc.bpg.domain.Room;
import com.uc.bpg.forms.RoomQueryForm;


public class RoomListControllerImpl extends BusinessListControllerBase<RoomQueryForm,Room> implements RoomListController{
	@Override
	protected RoomQueryForm onCreateNewQueryForm() {
		RoomQueryForm queryForm=new RoomQueryForm();
		return queryForm;
	}
}
