package com.uc.bpg.service.impl;

import java.util.Date;

import org.springframework.util.StringUtils;

import com.uc.bpg.forms.CheckInQueryForm;
import com.uc.bpg.service.BusinessListServiceBase;
import com.uc.bpg.service.CheckInListService;
import com.uc.web.forms.ListQueryForm;

public class CheckInListServiceImpl extends BusinessListServiceBase<CheckInQueryForm> implements CheckInListService {
	@Override
	public boolean prepareQueryForm(ListQueryForm query) {
		super.prepareQueryForm(query);
		CheckInQueryForm queryForm=(CheckInQueryForm) query;
		if(StringUtils.isEmpty(queryForm.getQueryCheckOutReceptionistName())) {
			queryForm.setQueryCheckInReceptionistName(null);
		}
		if(StringUtils.isEmpty(queryForm.getQueryRoomNo())) {
			queryForm.setQueryRoomNo(null);
		}
		queryForm.setQueryNow(new Date());
		return true;
	}
}
