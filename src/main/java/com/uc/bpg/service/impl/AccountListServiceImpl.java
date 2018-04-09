package com.uc.bpg.service.impl;

import org.springframework.util.StringUtils;

import com.uc.bpg.forms.BillQueryForm;
import com.uc.bpg.service.AccountListService;
import com.uc.bpg.service.BusinessListServiceBase;
import com.uc.utils.IntegerUtils;
import com.uc.web.forms.ListQueryForm;

public class AccountListServiceImpl extends BusinessListServiceBase<BillQueryForm> implements AccountListService {

	@Override
	public boolean prepareQueryForm(ListQueryForm query) {
		super.prepareQueryForm(query);
		BillQueryForm queryForm=(BillQueryForm) query;
		
		if (!IntegerUtils.isEmpty(queryForm.getQueryHotel())) {
			queryForm.setQueryHotelName(null);			
		} else {
			queryForm.setQueryHotel(null);
			if (StringUtils.isEmpty(queryForm.getQueryHotelName())) {				
				queryForm.setQueryHotelName(null);
			}
		}
		
		String[] states = null;
		if (!StringUtils.isEmpty(queryForm.getQueryState())) {
			states =StringUtils.tokenizeToStringArray(queryForm.getQueryState(), ",");
			if(states==null || states.length==0) {
				queryForm.setQueryStates(null);
			} else {
				queryForm.setQueryStates(states);
			}
		}
		if (StringUtils.isEmpty(queryForm.getQueryPayerName())) {
			queryForm.setQueryPayerName(null);
		}
		if (StringUtils.isEmpty(queryForm.getQueryVerifierName())) {
			queryForm.setQueryVerifierName(null);
		}
		return true;
	}
}
