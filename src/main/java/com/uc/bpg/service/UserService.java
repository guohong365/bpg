package com.uc.bpg.service;

import java.util.List;

import com.uc.bpg.domain.RoleAvailable;
import com.uc.bpg.domain.UserImpl;
import com.uc.web.forms.MenuTreeItem;
import com.uc.web.service.basic.IntegerKeyAppDetailService;

public interface UserService extends IntegerKeyAppDetailService<UserImpl> {
	public List<RoleAvailable> selectAvailableRoles();

	public int updatePassword(Long id, String password);
	
	public List<? extends MenuTreeItem<Long>> selectUserMenuItems(Long userId);
	
	public List<RoleAvailable> selectAvailableRoles(Long userId);


}
