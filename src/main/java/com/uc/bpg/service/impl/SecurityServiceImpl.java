package com.uc.bpg.service.impl;

import java.util.List;

import com.uc.bpg.domain.MenuTree;
import com.uc.bpg.domain.Orgnization;
import com.uc.bpg.domain.RoleAvailable;
import com.uc.bpg.domain.UserImpl;
import com.uc.bpg.domain.UserProfile;
import com.uc.bpg.persistence.OrgnizationMapper;
import com.uc.bpg.persistence.RoleFunctionDefineMapper;
import com.uc.bpg.persistence.UserMapper;
import com.uc.bpg.service.SecurityService;
import com.uc.web.domain.basic.NoParentFoundException;
import com.uc.web.domain.security.IRoleFunctionDefine;
import com.uc.web.forms.MenuTreeItem;


public class SecurityServiceImpl implements SecurityService {
	
	private UserMapper userDetailMapper;
	private OrgnizationMapper orgnizaiontDetaillMapper;
	private RoleFunctionDefineMapper roleFunctionDefineMapper;
	
	public void setOrgnizaiontDetaillMapper(OrgnizationMapper orgnizaiontDetaillMapper) {
		this.orgnizaiontDetaillMapper = orgnizaiontDetaillMapper;
	}
	
	public void setRoleFunctionDefineMapper(RoleFunctionDefineMapper roleFunctionDefineMapper) {
		this.roleFunctionDefineMapper=roleFunctionDefineMapper;
	}
	
	public void setUserDetailMapper(UserMapper userDetailMapper) {
		this.userDetailMapper = userDetailMapper;
	}

	@Override
	public UserProfile selectUserProfile(String loginId) {
		
		UserImpl user=userDetailMapper.selectByUuid(loginId);
		if(user==null)
			return null;
		UserProfile userProfile=new UserProfile();
		userProfile.setUser(user);
		Orgnization orgnizationDetailForm= orgnizaiontDetaillMapper.selectById(user.getOrg());
		userProfile.setOrgnization(orgnizationDetailForm);
		List<RoleAvailable> roles=userDetailMapper.selectUserRoles(user.getId(), false);
		userProfile.addRole(roles);
		List<? extends MenuTreeItem<Long>> menuTreeItems=userDetailMapper.selectUserMenuItems(user.getId());
		MenuTree menuTree=null;
		try {
			menuTree=MenuTree.buildMenuTree(menuTreeItems);
		} catch (NoParentFoundException e) {
			e.printStackTrace();
		}
		userProfile.setMenu(menuTree);
		
		//userProfile.setSettings(new UserSettings(userProfile));
		
		return userProfile;
	}

	@Override
	public List<? extends IRoleFunctionDefine<Long>> selectRoleFunctionDefines() {
		return roleFunctionDefineMapper.selectRoleFunctionDefines();
	}
}
