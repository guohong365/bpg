package com.uc.bpg.controller.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.uc.bpg.controller.BusinessDetailControllerBase;
import com.uc.bpg.controller.UserDetailController;
import com.uc.bpg.domain.RoleAvailable;
import com.uc.bpg.domain.UserImpl;
import com.uc.bpg.service.CodesService;
import com.uc.bpg.service.UserDetailService;
import com.uc.web.controller.WebAction;
import com.uc.web.domain.Code;
import com.uc.web.domain.basic.IntegerCode;
import com.uc.web.domain.security.UserProfile;

public class UserDetailControllerImpl extends BusinessDetailControllerBase<UserImpl> implements UserDetailController{
    private static final String ORG_CODE_NAME="_ORGS";
    CodesService codesService;
    
    public void setCodesService(CodesService codesService) {
		this.codesService = codesService;
	}
    
    protected CodesService getCodesService() {
		return codesService;
	}
	
    public UserDetailService getService(){
    	return (UserDetailService) super.getService();
    }
    
	@Override
	protected UserImpl onCreateEntity() {
		UserImpl detail= new UserImpl();
		detail.setRoles(getService().selectAvailableRoles());
		return detail;
	}
	
	@Override
	protected void onBeforSaveDetail(UserProfile user, String action, UserImpl detail)
			throws Exception {
		switch (action) {
		case WebAction.NEW:
			detail.setValid(true);
			detail.setCreater(getUserProfile().getUser().getId());
			detail.setCreateTime(new Date());
			getLogger().trace("has roles=" + (detail.getRoles()==null? 0 : detail.getRoles().size() ));
			if(getLogger().isTraceEnabled() && detail.getRoles()!=null)
			{
				for(RoleAvailable roleAvailable : detail.getRoles()){
					getLogger().trace("roleId={}, valid={}", roleAvailable.getId(), roleAvailable.isAvailable());
				}
			}
			break;
		case WebAction.MODIFY:
			if(StringUtils.isEmpty(detail.getPassword())){
				detail.setPassword(null);
			}
			break;
		case WebAction.CANCELATE:
			detail.setCancelater(getUserProfile().getUser().getId());
			detail.setCancelTime(new Date());
			break;
		case WebAction.REACTIVE:
			break;

		default:
			break;
		}
		super.onBeforSaveDetail(user, action, detail);
	}
	
	@Override
	protected void saveReactive(UserImpl detail) {
		UserImpl temp=getService().selectById(detail.getId());
		temp.setCancelater(null);
		temp.setCancelTime(null);
		temp.setValid(true);
		getService().update(temp);
	}
	
	@Override
	protected void saveModify(UserImpl detail) {
		getService().updateSelective(detail);
	}
	@Override
	protected void saveCancelate(UserImpl detail) {
		UserImpl temp=new UserImpl();
        temp.setId(detail.getId());
        temp.setValid(false);
        temp.setCancelater(detail.getCancelater());
        temp.setCancelTime(detail.getCancelTime());
        getService().updateSelective(temp);
	}
	
	@Override
	protected Map<String, List<? extends Code<?>>> onGetNewCodes(UserProfile user) {
		Map<String, List<? extends Code<?>>> map= super.onGetNewCodes(user);
		List<IntegerCode> codes=  getCodesService().selectOrgCodes(null, true);
		map.put(ORG_CODE_NAME, codes);
		return map;
	}
	
	@Override
	protected Map<String, List<? extends Code<?>>> onGetModifyCodes(UserProfile user,	UserImpl detail) {
		return onGetNewCodes(user);
	}

}
