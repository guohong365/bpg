package com.uc.bpg.controller.hotel.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.CheckIn;
import com.uc.bpg.forms.CheckInQueryForm;
import com.uc.web.controller.ListController;
import com.uc.web.controller.basic.AbstractIntegerKeyListControllerProxy;

@Controller
@RequestMapping(value="${controller.proxy.uri.hotel.checkin}")
public class ForeCheckInListControllerProxy extends AbstractIntegerKeyListControllerProxy<CheckInQueryForm, CheckIn>{
	@Value("${controller.proxy.uri.hotel.checkin}")
	private String baseUri;
	
	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}
	
	@Resource(name="${controller.impl.list.hotel.checkin}")
	@Override
	public void setListController(ListController<Long, CheckInQueryForm, CheckIn> listController) {
		super.setListController(listController);
	}

}
