package com.uc.bpg.service.impl;


import java.util.List;

import com.uc.bpg.domain.RoleAvailable;
import com.uc.bpg.domain.UserImpl;
import com.uc.bpg.persistence.UserMapper;
import com.uc.bpg.service.UserDetailService;
import com.uc.web.forms.MenuTreeItem;
import com.uc.web.service.AppDetailServiceBase;

public class UserDetailServiceImpl extends AppDetailServiceBase<Long, UserImpl> implements UserDetailService {
	
	@Override
	public int delete(UserImpl detail) {
		return 0;
	}
	
	public UserMapper getMapper(){
		return (UserMapper)super.getMapper();
	}

	@Override
	public List<RoleAvailable> selectAvailableRoles() {
		return getMapper().selectUserRoles(null, true);
	}

	@Override
	public int updatePassword(Long id, String password) {
		UserImpl detail=new UserImpl();
		detail.setId(id);
		detail.setPassword(password);
		return getMapper().updateDetailSelective(detail);
	}

	@Override
	public List<? extends MenuTreeItem<Long>> selectUserMenuItems(Long userId) {
		return getMapper().selectUserMenuItems(userId);		
	}

	@Override
	public void onAfterSelected(UserImpl detail) {
		detail.setRoles(getMapper().selectUserRoles(detail.getId(), true));
	}

	@Override
	public List<RoleAvailable> selectAvailableRoles(Long userId) {
		return getMapper().selectUserRoles(userId, true);
	}

}
