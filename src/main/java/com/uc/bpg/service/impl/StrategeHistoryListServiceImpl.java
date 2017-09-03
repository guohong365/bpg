package com.uc.bpg.service.impl;

import com.uc.bpg.domain.StrategeHistory;
import com.uc.bpg.forms.StrategeQueryForm;
import com.uc.bpg.service.StrategeHistoryListService;
import com.uc.web.persistence.Example;
import com.uc.web.service.AppWebListServiceBase;


public class StrategeHistoryListServiceImpl extends AppWebListServiceBase<StrategeQueryForm, StrategeHistory> implements StrategeHistoryListService{

	@Override
	public boolean prepareExample(StrategeQueryForm queryForm, Example example) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
