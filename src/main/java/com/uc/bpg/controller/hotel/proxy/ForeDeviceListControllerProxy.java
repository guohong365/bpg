package com.uc.bpg.controller.hotel.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.Device;
import com.uc.bpg.forms.DeviceQueryForm;
import com.uc.web.controller.ListController;
import com.uc.web.controller.basic.AbstractIntegerKeyListControllerProxy;

@Controller
@RequestMapping("${controller.proxy.uri.hotel.device}")
public class ForeDeviceListControllerProxy extends AbstractIntegerKeyListControllerProxy<DeviceQueryForm, Device> {

	@Value("${controller.proxy.uri.hotel.device}")
	private String baseUri;
	
	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}

	@Resource(name="${controller.impl.list.hotel.device}")
	@Override
	public void setListController(ListController<Long, DeviceQueryForm, Device> listController) {
		super.setListController(listController);
	}

}
