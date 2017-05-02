package com.uc.bpg.forms;

import com.uc.web.forms.QueryForm;

public interface IQueryFormBase extends QueryForm<Long> {
	Long getQueryHotel();
	void setQueryHotel(Long hotel);

}
