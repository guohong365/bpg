package com.uc.bpg.controller;

import com.uc.bpg.forms.IQueryFormBase;
import com.uc.web.controller.basic.AbstractIntegerKeyController;

public class BusinessController<QueryFormType extends IQueryFormBase, DetailType>
	extends AbstractIntegerKeyController<QueryFormType, DetailType> {

	@Override
	public QueryFormType createQueryForm() {
		return getListController().createQueryForm();
	}
}
