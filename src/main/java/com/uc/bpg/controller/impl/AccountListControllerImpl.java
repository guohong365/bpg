package com.uc.bpg.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.uc.bpg.Constant;
import com.uc.bpg.controller.BusinessListControllerBase;
import com.uc.bpg.domain.Bill;
import com.uc.bpg.forms.BillQueryForm;
import com.uc.web.domain.basic.BasicCode;
import com.uc.web.domain.security.UserProfile;

public class AccountListControllerImpl extends BusinessListControllerBase<BillQueryForm, Bill>{
	private static final String CODE_BILL_STATE="_QUERY_STATE";
	
	@Override
	protected BillQueryForm onCreateNewQueryForm() {
		BillQueryForm queryForm= new BillQueryForm();
		queryForm.setQueryState(Constant.BILL_STATE_UNPAYED);
		return queryForm;
	}
	
	@Override
	protected void onSetListModel(UserProfile<Long> user, Model model) {
		List<BasicCode> codes=new ArrayList<>(); 
		codes.add(new BasicCode("", "全部"));		
		codes.add(new BasicCode(Constant.BILL_STATE_UNPAYED,Constant.BILL_STATE_UNPAYED));
		codes.add(new BasicCode(Constant.BILL_STATE_PAYED,Constant.BILL_STATE_PAYED));
		codes.add(new BasicCode(Constant.BILL_STATE_VERIFIED,Constant.BILL_STATE_VERIFIED));
		model.addAttribute(CODE_BILL_STATE, codes);		
		super.onSetListModel(user, model);
	}
	
	

}
