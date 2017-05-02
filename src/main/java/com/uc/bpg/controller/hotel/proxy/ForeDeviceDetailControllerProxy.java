package com.uc.bpg.controller.hotel.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.Device;
import com.uc.web.controller.DetailController;
import com.uc.web.controller.basic.AbstractIntegerKeyDetailControllerProxy;

@Controller
@RequestMapping("${controller.proxy.uri.hotel.device}")
public class ForeDeviceDetailControllerProxy extends AbstractIntegerKeyDetailControllerProxy<Device> {
	@Value("${controller.proxy.uri.hotel.device}")
	private String baseUri;
	
	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}
	
	@Override
	@Resource(name="${controller.impl.detail.hotel.device}")
	public void setDetailController(DetailController<Long, Device> detailController) {
		super.setDetailController(detailController);
	}
}
