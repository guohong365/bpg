package com.uc.bpg.persistence;

import com.uc.web.persistence.AppInsertMapper;
import com.uc.web.persistence.AppOptimizedMapper;
import com.uc.web.persistence.AppSelectByKeyMapper;
import com.uc.web.persistence.AppUpdateMapper;
import com.uc.web.persistence.AppUuidMapper;

public interface FunctionMapper
	extends 
	AppInsertMapper,
	AppUpdateMapper,
	AppSelectByKeyMapper,
	AppUuidMapper,
	AppOptimizedMapper
	{

}