package com.uc.bpg.service.impl;

import com.uc.bpg.domain.Orgnization;
import com.uc.bpg.forms.OrgnizationQueryForm;
import com.uc.bpg.service.OrgnizationListService;
import com.uc.web.persistence.Example;
import com.uc.web.service.AppWebListServiceBase;

public class OrgnizationListServiceImpl extends AppWebListServiceBase<OrgnizationQueryForm, Orgnization> implements OrgnizationListService{

	@Override
	public boolean prepareExample(OrgnizationQueryForm queryForm, Example example) {
		// TODO Auto-generated method stub
		return false;
	}


}
