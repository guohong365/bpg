package com.uc.bpg.service.impl;

import org.springframework.util.StringUtils;

import com.uc.bpg.forms.RoomQueryForm;
import com.uc.bpg.service.BusinessListServiceBase;
import com.uc.bpg.service.RoomListService;
import com.uc.utils.IntegerUtils;
import com.uc.web.forms.ListQueryForm;


public class RoomListServiceImpl extends BusinessListServiceBase<RoomQueryForm> implements RoomListService{
	@Override
	public boolean prepareQueryForm(ListQueryForm query) {
		super.prepareQueryForm(query);
		RoomQueryForm queryForm=(RoomQueryForm) query;
		if(IntegerUtils.isEmpty(queryForm.getQueryHotel())){
			if(StringUtils.isEmpty(queryForm.getQueryHotelName())) {
				queryForm.setQueryHotelName(null);
			}
		}
		if(IntegerUtils.isEmpty(queryForm.getQueryStorey())) {
			queryForm.setQueryStorey(null);
		}
		if(StringUtils.isEmpty(queryForm.getQueryRoomNo())){			
			queryForm.setQueryRoomNo(null);
		}
		queryForm.setQueryAll(queryForm.getQueryAll()!=null && queryForm.getQueryAll());
		return true;
	}
}
