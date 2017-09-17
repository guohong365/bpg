package com.uc.bpg.service.impl;

import org.springframework.util.StringUtils;

import com.uc.bpg.forms.DeviceTypeQueryForm;
import com.uc.bpg.service.BusinessListServiceBase;
import com.uc.bpg.service.DeviceTypeListService;
import com.uc.web.persistence.Example;
import com.uc.web.persistence.QueryCondition;

public class DeviceTypeListServiceImpl extends BusinessListServiceBase<DeviceTypeQueryForm> implements DeviceTypeListService{

	@Override
	public boolean prepareExample(DeviceTypeQueryForm queryForm, Example example) {
		QueryCondition condition=example.or();
		if(StringUtils.isEmpty(queryForm.getQueryName())){
			queryForm.setQueryName(null);
		} else {
			condition.andFieldLike("NAME", queryForm.getQueryName()+"%");
		}
		if(StringUtils.isEmpty(queryForm.getQueryProduct())){
			queryForm.setQueryProduct(null);
		} else {
			condition.andFieldLike("PRODUCT", queryForm.getQueryProduct()+"%");
		}
		if(queryForm.getQueryAll()==null || !queryForm.getQueryAll()){
			queryForm.setQueryAll(false);
			condition.andFieldEqualTo("VALID", true);
		} else {
			queryForm.setQueryAll(true);
		}
		
		return true;
	}

}
