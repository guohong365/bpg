package com.uc.bpg.service.impl;

import com.uc.bpg.domain.Orgnization;
import com.uc.bpg.forms.OrgnizationQueryForm;
import com.uc.web.persistence.Example;
import com.uc.web.service.basic.GenericIntegerKeyAppListService;

public class OrgnizationListServiceImpl extends GenericIntegerKeyAppListService<OrgnizationQueryForm, Orgnization>{

	@Override
	public boolean prepareExample(OrgnizationQueryForm queryForm, Example example) {
		// TODO Auto-generated method stub
		return false;
	}


}
