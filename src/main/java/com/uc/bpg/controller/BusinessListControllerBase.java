package com.uc.bpg.controller;

import com.uc.bpg.forms.IQueryFormBase;
import com.uc.web.controller.basic.AbstractIntegerKeyListController;

public class BusinessListControllerBase<QureyFormType extends IQueryFormBase,  DetailType> 
    extends AbstractIntegerKeyListController<QureyFormType, DetailType> {
	
	private boolean foreground;

	public boolean isForeground() {
		return foreground;
	}

	public void setForeground(boolean foreground) {
		this.foreground = foreground;
	}
	
	@Override
	protected void onSetUserQueryLimits(QureyFormType queryForm) {
		super.onSetUserQueryLimits(queryForm);
		if(isForeground()){
			queryForm.setQueryHotel(getUserProfile().getOrgnization().getId());
		}
	}
	
}
