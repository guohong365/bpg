package com.uc.bpg.controller;

import com.uc.bpg.domain.UserProfileImpl;
import com.uc.bpg.forms.IQueryFormBase;
import com.uc.web.controller.AbstractController;
import com.uc.web.forms.ListQueryForm;

public class BusinessController<DetailType, QureyFormType extends IQueryFormBase> 
	extends AbstractController<Long, DetailType, QureyFormType> {
	
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
	public UserProfileImpl getUser(){
		return (UserProfileImpl) super.getUser();
	}
	
	private boolean foreground;

	public boolean isForeground() {
		return foreground;
	}

	public void setForeground(boolean foreground) {
		this.foreground = foreground;
	}
	
	@Override
	protected void onSetUserQueryLimits(ListQueryForm query) {
		@SuppressWarnings("unchecked")
		QureyFormType queryForm=(QureyFormType) query;
		if(isForeground()){
			queryForm.setQueryHotel((Long) getUser().getOrgnization().getId());
			System.err.println("..............................................");
		}
	}

}
