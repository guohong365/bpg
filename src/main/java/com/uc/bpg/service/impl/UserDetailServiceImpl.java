package com.uc.bpg.service.impl;

import java.util.List;

import com.uc.bpg.domain.RoleAvailable;
import com.uc.bpg.domain.UserImpl;
import com.uc.bpg.persistence.UserMapper;
import com.uc.bpg.service.UserService;
import com.uc.web.forms.MenuTreeItem;
import com.uc.web.service.basic.GenericIntegerKeyAppDetailService;

public class UserDetailServiceImpl extends GenericIntegerKeyAppDetailService<UserImpl> implements UserService {
	
	@Override
	public int delete(UserImpl detail) {
		return 0;
	}
	
	protected UserMapper getUserMapper(){
		return (UserMapper)getAppDetailMapper();
	}

	@Override
	public List<RoleAvailable> selectAvailableRoles() {
		return getUserMapper().selectUserRoles(null, true);
	}

	@Override
	public int updatePassword(Long id, String password) {
		UserImpl detail=new UserImpl();
		detail.setId(id);
		detail.setPassword(password);
		return getAppDetailMapper().updateDetailSelective(detail);
	}

	@Override
	public List<? extends MenuTreeItem<Long>> selectUserMenuItems(Long userId) {
		return getUserMapper().selectUserMenuItems(userId);		
	}

	@Override
	public void onAfterSelected(UserImpl detail) {
		detail.setRoles(getUserMapper().selectUserRoles(detail.getId(), true));
	}

	@Override
	public List<RoleAvailable> selectAvailableRoles(Long userId) {
		return getUserMapper().selectUserRoles(userId, true);
	}

}
