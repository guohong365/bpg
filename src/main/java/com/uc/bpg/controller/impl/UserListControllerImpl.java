package com.uc.bpg.controller.impl;

import com.uc.bpg.domain.UserImpl;
import com.uc.bpg.forms.UserQueryForm;
import com.uc.web.controller.basic.AbstractIntegerKeyListController;

public class UserListControllerImpl extends AbstractIntegerKeyListController<UserQueryForm, UserImpl> {

	@Override
	protected UserQueryForm onCreateNewQueryForm() {
		UserQueryForm queryForm=new UserQueryForm();
		queryForm.setQueryValid(true);
		queryForm.setQueryAll(false);
		return queryForm;
	}

}
