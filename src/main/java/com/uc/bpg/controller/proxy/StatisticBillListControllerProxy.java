package com.uc.bpg.controller.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.StatisticBill;
import com.uc.bpg.forms.StatisticBillQueryForm;
import com.uc.web.controller.ListController;
import com.uc.web.controller.basic.AbstractIntegerKeyListControllerProxy;

@Controller
@RequestMapping(value="${controller.proxy.uri.background.statistic.bill}")
public class StatisticBillListControllerProxy extends AbstractIntegerKeyListControllerProxy<StatisticBillQueryForm, StatisticBill> {
	
	@Value(value="${controller.proxy.uri.background.statistic.bill}")
	String baseUri;

	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}
	
	@Resource(name="${controller.impl.list.background.statistic.bill}")
	@Override
	public void setListController(ListController<Long, StatisticBillQueryForm, StatisticBill> listController) {
		super.setListController(listController);
	}
	

}
