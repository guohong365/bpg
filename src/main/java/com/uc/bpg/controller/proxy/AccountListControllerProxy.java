package com.uc.bpg.controller.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.Bill;
import com.uc.bpg.forms.BillQueryForm;
import com.uc.web.controller.ListController;
import com.uc.web.controller.basic.AbstractIntegerKeyListControllerProxy;

@Controller
@RequestMapping(value="${controller.proxy.uri.background.account}")
public class AccountListControllerProxy extends AbstractIntegerKeyListControllerProxy<BillQueryForm, Bill> {
	
	@Value(value="${controller.proxy.uri.background.account}")
	String baseUri;

	@Resource(name="${controller.impl.list.background.account}")
	@Override
	public void setListController(ListController<Long, BillQueryForm, Bill> listController) {
		super.setListController(listController);
	}

	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}

}
