package com.uc.bpg.service.impl;

import org.springframework.util.StringUtils;

import com.uc.bpg.forms.ExamineQueryForm;
import com.uc.bpg.service.BusinessListServiceBase;
import com.uc.bpg.service.ExamineListService;
import com.uc.web.forms.ListQueryForm;

public class ExamineListServiceImpl extends BusinessListServiceBase<ExamineQueryForm> implements ExamineListService {
	@Override
	public boolean prepareQueryForm(ListQueryForm query) {
		super.prepareQueryForm(query);
		ExamineQueryForm queryFormType=(ExamineQueryForm) query;

		if(StringUtils.isEmpty(queryFormType.getQueryMac())){
			queryFormType.setQueryMac(null);
		}		
		return true;
	}

}
