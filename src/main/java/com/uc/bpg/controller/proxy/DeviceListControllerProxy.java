package com.uc.bpg.controller.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.Device;
import com.uc.bpg.forms.DeviceQueryForm;
import com.uc.web.controller.ListController;
import com.uc.web.controller.basic.AbstractIntegerKeyListControllerProxy;
@Controller
@RequestMapping(value="${controller.proxy.uri.background.device}")
public class DeviceListControllerProxy extends AbstractIntegerKeyListControllerProxy<DeviceQueryForm, Device> {
	
	@Value(value="${controller.proxy.uri.background.device}")
	private String baseUri;

	@Resource(name="${controller.impl.list.background.device}")
	@Override
	public void setListController(ListController<Long, DeviceQueryForm, Device> listController) {
		super.setListController(listController);
	}

	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}
	
}
