package com.uc.bpg.service;

import java.util.List;

import com.uc.bpg.domain.MenuTreeItem;
import com.uc.web.domain.basic.IntegerCode;

public interface CodesService {
	List<IntegerCode> selectTypes(boolean forEdit);
	
	List<MenuTreeItem> selectAllMenus();

	List<IntegerCode> selectOrgCodes(String type, boolean forEdit);

	List<IntegerCode> selectAllocableHotelCodes();
	

}
