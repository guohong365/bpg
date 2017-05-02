package com.uc.bpg.service.impl;

import com.uc.bpg.domain.Stratege;
import com.uc.bpg.service.StrategeService;
import com.uc.web.persistence.AppUuidMapper;
import com.uc.web.service.basic.GenericIntegerKeyAppDetailService;

public class StrategeDetailServiceImpl 
	extends GenericIntegerKeyAppDetailService<Stratege>
	implements StrategeService {
	
	@SuppressWarnings("unchecked")
	AppUuidMapper<Long, Stratege> getUuidMapper(){
		if(getAppDetailMapper() instanceof AppUuidMapper){
			return (AppUuidMapper<Long, Stratege>) getAppDetailMapper();
		}
		return null;
	}
	
	@Override
	public Long selectId() {
		AppUuidMapper<Long, Stratege> mapper=getUuidMapper();
		if(mapper!=null){
			return mapper.selectIdByUuid("root");
		}
		return null;
	}
}
