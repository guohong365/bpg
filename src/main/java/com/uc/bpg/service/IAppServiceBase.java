package com.uc.bpg.service;

import com.uc.bpg.forms.IQueryFormBase;
import com.uc.web.service.AppService;

public interface IAppServiceBase<QueryFormType extends IQueryFormBase, DetailType> 
	extends AppService<Long, QueryFormType, DetailType> {

}
