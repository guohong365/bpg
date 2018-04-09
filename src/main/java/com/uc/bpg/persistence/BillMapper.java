package com.uc.bpg.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uc.bpg.domain.Bill;
import com.uc.bpg.domain.DeviceUsage;
import com.uc.web.persistence.AppInsertMapper;
import com.uc.web.persistence.AppOptimizedMapper;
import com.uc.web.persistence.AppSelectByKeyMapper;
import com.uc.web.persistence.AppUpdateMapper;

public interface BillMapper extends AppInsertMapper, AppUpdateMapper, AppOptimizedMapper, AppSelectByKeyMapper {
	void insertGeneratedBill(
			@Param("bill")
			Bill bill,
			@Param("usages")
			List<DeviceUsage> usages);
}