package com.uc.bpg.service.impl;

import java.util.Date;

import com.uc.bpg.Constant;
import com.uc.bpg.domain.Bill;
import com.uc.bpg.service.AccountService;
import com.uc.web.service.basic.GenericIntegerKeyAppDetailService;

public class AccountDetailServiceImpl extends GenericIntegerKeyAppDetailService<Bill> implements AccountService {
	@Override
	public	int pay(Bill detail){
		Bill bill=new Bill();
		bill.setId(detail.getId());
		bill.setPayer(detail.getPayer());
		bill.setState(Constant.BILL_STATE_PAYED);
		bill.setPayTime(new Date());
		return updateSelective(bill);
	}
	@Override
	public	int verify(Bill detail){
		Bill bill=new Bill();
		bill.setId(detail.getId());
		bill.setVerifier(detail.getVerifier());
		bill.setVerifyTime(new Date());
		bill.setState(Constant.BILL_STATE_VERIFIED);
		return updateSelective(bill);
	}
}
