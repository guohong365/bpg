package com.uc.bpg.service;

import java.util.List;

import com.uc.bpg.domain.FunctionAvailable;
import com.uc.bpg.domain.Role;
import com.uc.web.service.AppDetailService;

public interface RoleDetailService extends AppDetailService<Long, Role>{

	List<FunctionAvailable> seletctFunctions();

}
