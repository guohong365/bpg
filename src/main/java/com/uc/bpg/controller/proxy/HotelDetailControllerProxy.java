package com.uc.bpg.controller.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.Hotel;
import com.uc.web.controller.DetailController;
import com.uc.web.controller.basic.AbstractIntegerKeyDetailControllerProxy;

@Controller
@RequestMapping(value="${controller.proxy.uri.background.hotel}")
public class HotelDetailControllerProxy extends AbstractIntegerKeyDetailControllerProxy<Hotel> {

	@Value(value="${controller.proxy.uri.background.hotel}")
	private String baseUri;
	
	@Resource(name="${controller.impl.detail.background.hotel}")
	@Override
	public void setDetailController(DetailController<Long, Hotel> detailController) {
		super.setDetailController(detailController);
	}
	
	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}	
	

}
