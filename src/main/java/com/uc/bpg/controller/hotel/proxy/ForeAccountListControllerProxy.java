package com.uc.bpg.controller.hotel.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.Bill;
import com.uc.bpg.forms.BillQueryForm;
import com.uc.web.controller.ListController;
import com.uc.web.controller.basic.AbstractIntegerKeyListControllerProxy;
@Controller
@RequestMapping("${controller.proxy.uri.hotel.account}")
public class ForeAccountListControllerProxy extends AbstractIntegerKeyListControllerProxy<BillQueryForm, Bill> {

	@Value("${controller.proxy.uri.hotel.account}")
	private String baseUri;
	@Override
	protected String onGetBaseUri() {	
		return baseUri;
	}
	
	@Resource(name="${controller.impl.list.hotel.account}")
	@Override
	public void setListController(ListController<Long, BillQueryForm, Bill> listController) {
		super.setListController(listController);
	}
	
}
