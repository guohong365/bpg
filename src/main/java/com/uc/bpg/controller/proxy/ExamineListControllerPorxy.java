package com.uc.bpg.controller.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uc.bpg.domain.Examine;
import com.uc.bpg.forms.ExamineQueryForm;
import com.uc.web.controller.ListController;
import com.uc.web.controller.basic.AbstractIntegerKeyListControllerProxy;

@Controller
@RequestMapping(value="${controller.proxy.uri.examine}")
public class ExamineListControllerPorxy extends AbstractIntegerKeyListControllerProxy<ExamineQueryForm, Examine> {
	
	@Value(value="${controller.proxy.uri.examine}")
	private String baseUri;

	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}
	
	@Resource(name="${controller.impl.list.examine}")
	@Override	
	public void setListController(ListController<Long, ExamineQueryForm, Examine> listController) {
		super.setListController(listController);
	}

}
