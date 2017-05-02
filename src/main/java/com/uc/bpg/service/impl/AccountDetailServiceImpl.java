package com.uc.bpg.service.impl;

import com.uc.bpg.domain.Bill;
import com.uc.bpg.service.AccountService;
import com.uc.web.service.basic.GenericIntegerKeyAppDetailService;

public class AccountDetailServiceImpl extends GenericIntegerKeyAppDetailService<Bill> implements AccountService {
	@Override
	public	int pay(Bill detail){
		Bill bill=new Bill();
		bill.setId(detail.getId());
		bill.setPayer(detail.getPayer());
		bill.setState("已付款");
		return updateSelective(bill);
	}
	@Override
	public	int verify(Bill detail){
		Bill bill=new Bill();
		bill.setId(detail.getId());
		bill.setVerifier(detail.getVerifier());
		bill.setState("确认付款");
		return updateSelective(bill);
	}
}
