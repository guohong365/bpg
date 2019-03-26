package com.uc.bpg.controller;

import com.uc.bpg.domain.UserProfileImpl;
import com.uc.bpg.forms.IQueryFormBase;
import com.uc.web.controller.AbstractDetailListController;
import com.uc.web.forms.DetailListQueryForm;

public class BusinessDetailListController<DetailType,QueryFormType extends IQueryFormBase,  ChildQueryType extends DetailListQueryForm, ChildDetailType> 
	extends AbstractDetailListController<Long, DetailType,QueryFormType, ChildQueryType> {
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
	@Override
	public UserProfileImpl getUser(){
		return (UserProfileImpl) super.getUser();
	}
}
