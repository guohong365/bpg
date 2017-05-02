package com.uc.bpg.domain;

import com.uc.web.domain.AbstractMenu;

public class MenuTreeItem extends AbstractMenu<Long> implements com.uc.web.forms.MenuTreeItem<Long>{
	private String icon;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}	
}
