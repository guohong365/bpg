package com.uc.bpg.controller.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.Stratege;
import com.uc.web.controller.DetailController;
import com.uc.web.controller.basic.AbstractIntegerKeyDetailControllerProxy;

@Controller
@RequestMapping(value="${controller.proxy.uri.stratege}")
public class StrategeControllerProxy extends AbstractIntegerKeyDetailControllerProxy<Stratege> {

	@Value(value="${controller.proxy.uri.stratege}")
	private String baseUri;
	
	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}
	
	@Resource(name="${controller.impl.stratege}")
	@Override
	public void setDetailController(
			DetailController<Long, Stratege> detailController) {
		super.setDetailController(detailController);
	}

}
