package com.uc.bpg.service;

import com.uc.bpg.domain.Stratege;
import com.uc.web.service.AppDetailService;

public interface StrategeDetailService extends AppDetailService<Long, Stratege> {
	Long selectId();
}
