package com.uc.bpg.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;

import com.uc.bpg.domain.FunctionAvailable;
import com.uc.bpg.domain.Role;
import com.uc.bpg.test.TestBase;
import com.uc.web.service.basic.IntegerKeyAppDetailService;

public class RoleServiceTest extends TestBase {
	
	@Resource(name="roleDetailService")
	IntegerKeyAppDetailService<Role> service;
	
	@Test
	public void test(){
		Role role=new Role();
		role.setUuid(UUID.randomUUID().toString());
		role.setName("cccc");
		List<FunctionAvailable> funcs=new ArrayList<>();
		role.setFunctions(funcs);
		FunctionAvailable func=new FunctionAvailable();
		func.setId(1L);
		func.setAvailable(true);
		funcs.add(func);
		func=new FunctionAvailable();
		func.setId(2L);
		func.setAvailable(true);
		funcs.add(func);
		try{
		service.insert(role);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
