package com.uc.bpg.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.uc.bpg.controller.AllotHistoryListController;
import com.uc.bpg.domain.AllotHistory;
import com.uc.bpg.forms.AllotHisQueryForm;
import com.uc.bpg.service.DeviceDetailService;
import com.uc.web.controller.AbstractListController;
import com.uc.web.controller.DetailListController;
import com.uc.web.domain.basic.BasicCode;

public class AllotHistoryListControllerImpl extends AbstractListController<AllotHisQueryForm, AllotHistory> implements AllotHistoryListController{
	private static final String[] OPERATIONS={"分配", "收回","成为公用","报废"};
	private static final String CODE_OPT_NAME = "_OPTS";
	
	private DeviceDetailService deviceService;
	
	public void setDeviceService(DeviceDetailService deviceService) {
		this.deviceService = deviceService;
	}
	public DeviceDetailService getDeviceService() {
		return deviceService;
	}
	
	@Override
	protected String onGetListPage(Model model) {
		List<BasicCode> codes=new ArrayList<>();
		for(String opt:OPERATIONS){
			codes.add(new BasicCode(opt, opt));
		}
		model.addAttribute(CODE_OPT_NAME, codes);
		return super.onGetListPage(model);
	}
	
	@Override
	protected AllotHisQueryForm onCreateQueryForm() {		
		return new AllotHisQueryForm();
	}
	
	@Override
	protected Map<String, Object> prepareExportOptions(AllotHisQueryForm queryForm, List<AllotHistory> data) {
		Map<String, Object> options= super.prepareExportOptions(queryForm, data);
		if(queryForm.getQuerySelectedId()!=null && queryForm.getQuerySelectedId()>0 && getDeviceService()!=null){
			options.put(DetailListController.EXPORTOR_OPTION_DETAIL_DATA, getDeviceService().selectById(queryForm.getQuerySelectedId()));
		}
		return options;
	}
	
}
