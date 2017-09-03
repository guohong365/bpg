package com.uc.bpg.controller.impl;

import com.uc.bpg.controller.BusinessListControllerBase;
import com.uc.bpg.controller.HotelListController;
import com.uc.bpg.domain.Hotel;
import com.uc.bpg.forms.HotelQueryForm;

public class HotelListControllerImpl extends BusinessListControllerBase<HotelQueryForm, Hotel> implements HotelListController {

	@Override
	protected HotelQueryForm onCreateQueryForm() {
		return new HotelQueryForm();
	}
}
