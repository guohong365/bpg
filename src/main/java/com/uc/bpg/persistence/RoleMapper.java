package com.uc.bpg.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uc.bpg.domain.FunctionAvailable;
import com.uc.bpg.domain.Role;
import com.uc.web.persistence.AppMapper;

public interface RoleMapper extends AppMapper<Long, Role> {

	List<FunctionAvailable> selectFunctions(
			@Param("roleId")
			Long roleId,
			@Param("isAll")
			boolean isAll);

}