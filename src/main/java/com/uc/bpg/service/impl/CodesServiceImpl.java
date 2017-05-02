package com.uc.bpg.service.impl;

import java.util.List;

import com.uc.bpg.domain.MenuTreeItem;
import com.uc.bpg.persistence.CodesMapper;
import com.uc.bpg.service.CodesService;
import com.uc.web.domain.basic.IntegerCode;

public class CodesServiceImpl implements CodesService {

	CodesMapper mapper;
	
	public void setMapper(CodesMapper mapper) {
		this.mapper = mapper;
	}
	
	public CodesMapper getMapper() {
		return mapper;
	}
	
	@Override
	public List<IntegerCode> selectTypes(boolean forEdit) {
		return getMapper().selectTypes(forEdit);
	}

	@Override
	public List<MenuTreeItem> selectAllMenus() {
		return getMapper().selectAllMenus();
	}

	@Override
	public List<IntegerCode> selectOrgCodes(String type, boolean forEdit) {
		return getMapper().selectOrgCodes(type, forEdit);		
	}

	@Override
	public List<IntegerCode> selectAllocableHotelCodes() {
		return getMapper().selectAllocableHotelCodes();
	}

}
