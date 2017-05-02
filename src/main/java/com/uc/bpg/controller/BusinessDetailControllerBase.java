package com.uc.bpg.controller;

import com.uc.web.controller.basic.AbstractIntegerKeyDetailController;

public class BusinessDetailControllerBase<DetailType> 
	extends AbstractIntegerKeyDetailController<DetailType> {
	
	@Override
	protected String getNewPageName() {
		return getModifyPageName();
	}
	@Override
	protected String getCancelatePageName() {
		return getViewPageName();
	}
	@Override
	protected String getReactivePageName() {
		return getViewPageName();
	}
	@Override
	protected String getDeletePageName() {
		return getDeletePageName();
	}	
}
