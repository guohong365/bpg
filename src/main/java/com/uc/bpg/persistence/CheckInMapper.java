package com.uc.bpg.persistence;

import com.uc.bpg.domain.CheckIn;
import com.uc.bpg.forms.CheckInQueryForm;
import com.uc.web.persistence.AppMapper;
import com.uc.web.persistence.AppOptimizedMapper;

public interface CheckInMapper extends AppMapper<Long, CheckIn>, AppOptimizedMapper<CheckInQueryForm, CheckIn> {
	
}