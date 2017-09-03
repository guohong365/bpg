package com.uc.bpg.service.impl;

import com.uc.bpg.domain.Examine;
import com.uc.bpg.forms.ExamineQueryForm;
import com.uc.bpg.service.ExamineListService;
import com.uc.web.persistence.Example;
import com.uc.web.service.AppWebListServiceBase;

public class ExamineListServiceImpl extends AppWebListServiceBase<ExamineQueryForm, Examine> implements ExamineListService {
	@Override
	public boolean prepareExample(ExamineQueryForm queryFormType, Example example) {
		
		return true;
	}

}
