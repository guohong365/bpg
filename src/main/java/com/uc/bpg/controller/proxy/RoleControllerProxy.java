package com.uc.bpg.controller.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.Role;
import com.uc.bpg.forms.RoleQueryForm;
import com.uc.web.controller.GeneralController;
import com.uc.web.controller.basic.AbstractIntegerKeyControllerProxy;

@Controller
@RequestMapping(value="${controller.proxy.uri.role}")
public class RoleControllerProxy extends AbstractIntegerKeyControllerProxy<RoleQueryForm, Role> {

	@Value(value="${controller.proxy.uri.role}")
	private String baseUrl;
	
	@Override
	protected String onGetBaseUrl() {
		return baseUrl;
	}
	
	@Resource(name="${controller.impl.role}")
	@Override
	public void setContorller(GeneralController<Long,  RoleQueryForm,  Role> controller) {
		super.setContorller(controller);
	}

}
