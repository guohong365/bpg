package com.uc.bpg.service.impl;

import java.util.Date;

import com.uc.bpg.domain.CheckIn;
import com.uc.bpg.forms.CheckInQueryForm;
import com.uc.bpg.service.BusinessListServiceBase;
import com.uc.web.persistence.Example;

public class CheckInListServiceImpl extends BusinessListServiceBase<CheckInQueryForm, CheckIn> {
	@Override
	public boolean prepareExample(CheckInQueryForm queryForm, Example example) {
		super.prepareExample(queryForm, example);
		queryForm.setQueryNow(new Date());
		return true;
	}
}
