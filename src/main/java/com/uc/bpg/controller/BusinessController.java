package com.uc.bpg.controller;

import com.uc.bpg.forms.IQueryFormBase;
import com.uc.web.controller.AbstractController;

public class BusinessController<QueryFormType extends IQueryFormBase, DetailType>
	extends AbstractController<Long, QueryFormType, DetailType> {

	@Override
	public QueryFormType createQueryForm() {
		return getListController().createQueryForm();
	}
}
