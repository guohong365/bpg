package com.uc.bpg.controller.hotel.impl;

import com.uc.bpg.controller.BusinessListControllerBase;
import com.uc.bpg.domain.CheckIn;
import com.uc.bpg.forms.CheckInQueryForm;

public class CheckInListControllerImpl extends BusinessListControllerBase<CheckInQueryForm, CheckIn> {
	@Override
	protected CheckInQueryForm onCreateNewQueryForm() {
		return new CheckInQueryForm();
	}
}
