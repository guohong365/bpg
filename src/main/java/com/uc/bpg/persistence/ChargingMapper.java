package com.uc.bpg.persistence;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uc.web.persistence.AppInsertMapper;
import com.uc.web.persistence.AppOptimizedMapper;
import com.uc.web.persistence.AppSelectByKeyMapper;

public interface ChargingMapper extends AppInsertMapper, AppSelectByKeyMapper, AppOptimizedMapper {

	BigDecimal selectChargingStandard(
			@Param("ids")
			List<Long> ids);
}