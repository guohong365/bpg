package com.uc.bpg.service.impl;

import com.uc.bpg.domain.Stratege;
import com.uc.bpg.service.StrategeDetailService;
import com.uc.web.service.AppDetailServiceBase;

public class StrategeDetailServiceImpl extends AppDetailServiceBase<Long, Stratege> implements StrategeDetailService {
	
	@Override
	public Long selectId() {
		return getUuidMapper().selectIdByUuid("root");
	}
}
