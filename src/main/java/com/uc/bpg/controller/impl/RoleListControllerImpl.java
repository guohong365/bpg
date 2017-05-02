package com.uc.bpg.controller.impl;

import com.uc.bpg.domain.Role;
import com.uc.bpg.forms.RoleQueryForm;
import com.uc.web.controller.basic.AbstractIntegerKeyListController;

public class RoleListControllerImpl extends AbstractIntegerKeyListController<RoleQueryForm, Role> {

	@Override
	protected RoleQueryForm onCreateNewQueryForm() {
		return new RoleQueryForm();
	}

}
