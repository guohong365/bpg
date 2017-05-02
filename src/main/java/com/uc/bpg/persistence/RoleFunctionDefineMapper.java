package com.uc.bpg.persistence;

import java.util.List;

import com.uc.bpg.domain.FunctionImpl;
import com.uc.bpg.domain.Role;
import com.uc.bpg.domain.RoleFunctionDefine;

public interface RoleFunctionDefineMapper {
   public List<RoleFunctionDefine> selectRoleFunctionDefines();
   public FunctionImpl selectFunction(String funcId);
   public Role selectRole(String roleId);
    
}