package com.uc.bpg.service;

import com.uc.bpg.domain.Bill;

public interface AccountService {

	int pay(Bill detail);

	int verify(Bill detail);

}
