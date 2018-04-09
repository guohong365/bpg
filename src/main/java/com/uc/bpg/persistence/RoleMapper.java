package com.uc.bpg.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uc.bpg.domain.FunctionAvailable;
import com.uc.web.persistence.AppInsertMapper;
import com.uc.web.persistence.AppOptimizedMapper;
import com.uc.web.persistence.AppSelectByKeyMapper;
import com.uc.web.persistence.AppUpdateMapper;
import com.uc.web.persistence.AppUuidMapper;

public interface RoleMapper 
	extends 
	AppSelectByKeyMapper, 
	AppInsertMapper, 
	AppUpdateMapper, 
	AppUuidMapper, 
	AppOptimizedMapper {

	List<FunctionAvailable> selectFunctions(
			@Param("roleId")
			Long roleId,
			@Param("isAll")
			boolean isAll);

}