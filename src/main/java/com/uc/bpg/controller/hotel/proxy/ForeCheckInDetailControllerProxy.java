package com.uc.bpg.controller.hotel.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.CheckIn;
import com.uc.web.controller.DetailController;
import com.uc.web.controller.basic.AbstractIntegerKeyDetailControllerProxy;

@Controller
@RequestMapping(value="${controller.proxy.uri.hotel.checkin}")
public class ForeCheckInDetailControllerProxy extends AbstractIntegerKeyDetailControllerProxy<CheckIn> {
	@Value("${controller.proxy.uri.hotel.checkin}")
	private String baseUri;

	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}
	
	@Resource(name="${controller.impl.detail.hotel.checkin}")
	@Override
	public void setDetailController(DetailController<Long, CheckIn> detailController) {
		super.setDetailController(detailController);
	}
}
