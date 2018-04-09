package com.uc.bpg.controller.proxy;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uc.bpg.controller.AccountDetailListController;
import com.uc.bpg.domain.Bill;
import com.uc.bpg.domain.DeviceUsage;
import com.uc.bpg.forms.DeviceUsageQueryForm;
import com.uc.web.controller.AbstractDetailListControllerProxy;
import com.uc.web.controller.ControllerBase;
@Controller
@RequestMapping("${controller.proxy.uri.background.account}")
public class AccountDetailListControllerProxy 
	extends AbstractDetailListControllerProxy<Long, Bill, DeviceUsageQueryForm, DeviceUsage> implements AccountDetailListController{
	
	private static final String URI_PATH_DETAIL_LIST_EXPORT ="/detail/export";
	
	
	@Value(value="${controller.proxy.uri.background.account}")
	@Override
	public void setBaseUri(String baseUri) {
		super.setBaseUri(baseUri);
	}
	
	
	@Resource(name="${controller.impl.detail.background.account}")
	@Override
	public void setController(ControllerBase controller) {
		super.setController(controller);
	}
	
	@Override
	public AccountDetailListController getController() {
		return (AccountDetailListController) super.getController();
	}
	
	@Override
	@RequestMapping(value=URI_PATH_DETAIL_LIST_EXPORT, method=RequestMethod.POST)
	public void exportFile(
			@ModelAttribute(value=PARAM_NAME_QUERY_INPUT)
			DeviceUsageQueryForm queryForm, 
			HttpServletRequest request, 
			HttpServletResponse response) {
		getController().exportFile(queryForm, request, response);
	}

}
