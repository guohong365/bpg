package com.uc.bpg.service.impl;

import com.uc.bpg.domain.Examine;
import com.uc.bpg.forms.ExamineQueryForm;
import com.uc.bpg.service.ExamineService;
import com.uc.web.persistence.Example;
import com.uc.web.service.basic.GenericIntegerKeyAppListService;

public class ExamineListServiceImpl extends GenericIntegerKeyAppListService<ExamineQueryForm, Examine> implements ExamineService {
	@Override
	public boolean prepareExample(ExamineQueryForm queryFormType, Example example) {
		
		return true;
	}

}
