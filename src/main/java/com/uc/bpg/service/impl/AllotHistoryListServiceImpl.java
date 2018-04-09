package com.uc.bpg.service.impl;

import org.springframework.util.StringUtils;

import com.uc.bpg.forms.AllotHisQueryForm;
import com.uc.bpg.service.AllotHistoryListService;
import com.uc.bpg.service.BusinessListServiceBase;
import com.uc.utils.IntegerUtils;
import com.uc.web.forms.ListQueryForm;

public class AllotHistoryListServiceImpl extends BusinessListServiceBase<AllotHisQueryForm> implements AllotHistoryListService {
	@Override
	public boolean prepareQueryForm(ListQueryForm query) {
		super.prepareQueryForm(query);
		AllotHisQueryForm queryForm=(AllotHisQueryForm)query;
		
		if(IntegerUtils.isEmpty(queryForm.getQueryHotel())){			
			queryForm.setQueryHotel(null);
		}
		if(StringUtils.isEmpty(queryForm.getQueryHotelName())){			
			queryForm.setQueryHotelName(null);
		}
		if(StringUtils.isEmpty(queryForm.getQueryOperaterName())){			
			queryForm.setQueryOperaterName(null);
		}
		if(StringUtils.isEmpty(queryForm.getQueryRoom())){			
			queryForm.setQueryRoom(null);
		}
		if(IntegerUtils.isEmpty(queryForm.getQueryMainId())){			
			queryForm.setQueryMainId(null);
		}
		if(StringUtils.isEmpty(queryForm.getQueryOperation())){
			queryForm.setQueryOperation(null);
		}
		return true;
	}

}
