package com.uc.bpg.controller.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.DeviceType;
import com.uc.bpg.forms.DeviceTypeQueryForm;
import com.uc.web.controller.GeneralController;
import com.uc.web.controller.basic.AbstractIntegerKeyControllerProxy;

@Controller
@RequestMapping(value="${controller.proxy.uri.device.type}")
public class DeviceTypeControllerProxy extends AbstractIntegerKeyControllerProxy<DeviceTypeQueryForm, DeviceType> {
	
	@Value(value="${controller.proxy.uri.device.type}")
	private String baseUri;

	@Override
	protected String onGetBaseUrl() {
		return baseUri;
	}
	@Resource(name="${controller.impl.device.type}")
	@Override
	public void setContorller(GeneralController<Long, DeviceTypeQueryForm,  DeviceType> controller) {
		super.setContorller(controller);
	}

}
