package com.uc.bpg.controller;

import com.uc.bpg.domain.UserProfile;
import com.uc.web.controller.AbstractDetailController;

public class BusinessDetailControllerBase<DetailType> 
	extends AbstractDetailController<Long, DetailType> {
	
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
	protected UserProfile getUserProfile(){
		return (UserProfile) getUser();
	}
}
