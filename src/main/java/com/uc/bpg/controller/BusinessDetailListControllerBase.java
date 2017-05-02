package com.uc.bpg.controller;

import com.uc.bpg.forms.IDetailListQueryForm;
import com.uc.web.controller.basic.GenericIntegerKeyDetailListController;

public class BusinessDetailListControllerBase<DetailType, ChildQueryType extends IDetailListQueryForm, ChildDetailType> 
	extends GenericIntegerKeyDetailListController<DetailType, ChildQueryType, ChildDetailType> {
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
}
