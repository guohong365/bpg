package com.uc.bpg.service.impl;

import com.uc.bpg.domain.StrategeHistory;
import com.uc.bpg.forms.StrategeQueryForm;
import com.uc.web.persistence.Example;
import com.uc.web.service.basic.GenericIntegerKeyAppService;


public class StrategeHistoryServiceImpl extends GenericIntegerKeyAppService<StrategeQueryForm, StrategeHistory>{

	@Override
	public boolean prepareExample(StrategeQueryForm queryForm, Example example) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
