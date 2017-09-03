package com.uc.bpg.controller.impl;

import com.uc.bpg.controller.BusinessListControllerBase;
import com.uc.bpg.controller.ExamineListController;
import com.uc.bpg.domain.Examine;
import com.uc.bpg.forms.ExamineQueryForm;

public class ExamineListControllerImp extends BusinessListControllerBase<ExamineQueryForm, Examine> implements ExamineListController {

	@Override
	protected ExamineQueryForm onCreateQueryForm() {
		return new ExamineQueryForm();
	}
}
