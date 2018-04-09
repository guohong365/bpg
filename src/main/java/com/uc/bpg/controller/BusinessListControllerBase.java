package com.uc.bpg.controller;

import com.uc.bpg.domain.UserProfileImpl;
import com.uc.bpg.forms.IQueryFormBase;
import com.uc.web.controller.AbstractListController;
import com.uc.web.forms.ListQueryForm;

public class BusinessListControllerBase<QureyFormType extends IQueryFormBase> 
    extends AbstractListController<QureyFormType> {
	
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
	@Override
	public UserProfileImpl getUser(){
		return (UserProfileImpl)super.getUser();
	}
}
