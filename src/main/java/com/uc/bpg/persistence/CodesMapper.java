package com.uc.bpg.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uc.bpg.domain.MenuTreeItem;
import com.uc.web.domain.basic.IntegerCode;

public interface CodesMapper {
	List<IntegerCode> selectTypes(
			@Param("forEdit")
			boolean forEdit);
	List<MenuTreeItem> selectAllMenus();
	List<IntegerCode> selectOrgCodes(
			@Param("type")
			String type,
			@Param("forEdit")
			boolean forEdit);
	List<IntegerCode> selectAllocableHotelCodes();
}
