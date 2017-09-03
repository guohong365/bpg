package com.uc.bpg.controller;

import com.uc.bpg.domain.UserProfile;
import com.uc.bpg.forms.IQueryFormBase;
import com.uc.web.controller.AbstractListController;

public class BusinessListControllerBase<QureyFormType extends IQueryFormBase,  DetailType> 
    extends AbstractListController<QureyFormType, DetailType> {
	
	private boolean foreground;

	public boolean isForeground() {
		return foreground;
	}

	public void setForeground(boolean foreground) {
		this.foreground = foreground;
	}
	
	
	protected void onSetUserQueryLimits(QureyFormType queryForm) {
		if(isForeground()){
			queryForm.setQueryHotel(getUserProfile().getOrgnization().getId());
		}
	}
	
	UserProfile getUserProfile(){
		return (UserProfile) getUser();
	}
}
