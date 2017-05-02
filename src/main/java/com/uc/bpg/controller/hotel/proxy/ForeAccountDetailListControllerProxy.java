package com.uc.bpg.controller.hotel.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.Bill;
import com.uc.bpg.domain.DeviceUsage;
import com.uc.bpg.forms.DeviceUsageQueryForm;
import com.uc.web.controller.DetailListController;
import com.uc.web.controller.basic.AbstractIntegerKeyDetailListControllerProxy;
@Controller
@RequestMapping("${controller.proxy.uri.hotel.account}")
public class ForeAccountDetailListControllerProxy 
	extends AbstractIntegerKeyDetailListControllerProxy<Bill, DeviceUsageQueryForm, DeviceUsage> {
	
	@Value(value="${controller.proxy.uri.hotel.account}")
	private String baseUri;

	@Override
	protected String onGetBaseUri() {
		return baseUri;		
	}
	
	
	@Override
	@Resource(name="${controller.impl.detail.hotel.account}")
	public void setDetailListController(
			DetailListController<Long, Bill, DeviceUsageQueryForm, DeviceUsage> controller) {
		super.setDetailListController(controller);
	}
	

}
