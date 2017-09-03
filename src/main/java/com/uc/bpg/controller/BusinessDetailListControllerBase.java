package com.uc.bpg.controller;

import com.uc.bpg.domain.UserProfile;
import com.uc.bpg.forms.IDetailListQueryForm;
import com.uc.web.controller.AbstractDetailListController;

public class BusinessDetailListControllerBase<DetailType, ChildQueryType extends IDetailListQueryForm, ChildDetailType> 
	extends AbstractDetailListController<Long, DetailType, ChildQueryType> {
	private boolean foreground;
	
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
	public boolean isForeground() {
		return foreground;
	}
	public void setForeground(boolean foreground) {
		this.foreground = foreground;
	}
	
	protected UserProfile getUserProfile(){
		return (UserProfile) getUser();
	}
}
