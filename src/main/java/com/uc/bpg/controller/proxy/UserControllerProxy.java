package com.uc.bpg.controller.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.UserImpl;
import com.uc.bpg.forms.UserQueryForm;
import com.uc.web.controller.GeneralController;
import com.uc.web.controller.basic.AbstractIntegerKeyControllerProxy;

@Controller
@RequestMapping(value="${controller.proxy.uri.user}")
public class UserControllerProxy extends AbstractIntegerKeyControllerProxy<UserQueryForm, UserImpl> {

	@Value(value="${controller.proxy.uri.user}") 
	private String baseUri;
	
	@Override
	protected String onGetBaseUrl() {
		return baseUri;
	}
	
	@Resource(name="${controller.impl.user}")
	@Override
	public void setContorller(GeneralController<Long,  UserQueryForm, UserImpl> controller) {
		super.setContorller(controller);
	}

}
