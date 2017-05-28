package com.uc.bpg.controller.hotel.impl;

import com.uc.bpg.controller.BusinessDetailControllerBase;
import com.uc.bpg.domain.CheckIn;

public class CheckInDetailControllerImpl extends BusinessDetailControllerBase<CheckIn> {
	@Override
	protected CheckIn onCreateNewDetail() {
		return new CheckIn();
	}
}
