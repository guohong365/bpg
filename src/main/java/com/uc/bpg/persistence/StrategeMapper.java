package com.uc.bpg.persistence;

import com.uc.bpg.domain.Stratege;
import com.uc.web.persistence.AppDetailMapper;
import com.uc.web.persistence.AppUuidMapper;

public interface StrategeMapper 
	extends AppDetailMapper<Long, Stratege>, 
			AppUuidMapper<Long, Stratege> {
}
