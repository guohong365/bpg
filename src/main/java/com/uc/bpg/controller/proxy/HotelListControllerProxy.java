package com.uc.bpg.controller.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.Hotel;
import com.uc.bpg.forms.HotelQueryForm;
import com.uc.web.controller.ListController;
import com.uc.web.controller.basic.AbstractIntegerKeyListControllerProxy;

@Controller
@RequestMapping(value="${controller.proxy.uri.background.hotel}")
public class HotelListControllerProxy extends AbstractIntegerKeyListControllerProxy<HotelQueryForm, Hotel> {

	@Value(value="${controller.proxy.uri.background.hotel}")
	private String baseUri;
	

	@Resource(name="${controller.impl.list.background.hotel}")
	@Override
	public void setListController(ListController<Long, HotelQueryForm, Hotel> listController) {
		super.setListController(listController);
	}

	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}	
	

}
