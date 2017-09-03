package com.uc.bpg.service;

import java.util.List;

import com.uc.bpg.domain.MenuTreeItem;
import com.uc.web.domain.basic.IntegerCode;
import com.uc.web.service.Service;

public interface CodesService extends Service {
	List<IntegerCode> selectTypes(boolean forEdit);
	
	List<MenuTreeItem> selectAllMenus();

	List<IntegerCode> selectOrgCodes(String type, boolean forEdit);

	List<IntegerCode> selectAllocableHotelCodes();
	

}
