package com.uc.bpg.persistence;

import java.util.List;

import com.uc.bpg.domain.StatisticBill;
import com.uc.bpg.forms.StatisticBillQueryForm;
import com.uc.web.persistence.AppOptimizedMapper;

public interface StatisticBillMapper extends AppOptimizedMapper<StatisticBillQueryForm, StatisticBill> {
	List<StatisticBill> selectStatistic(StatisticBillQueryForm query);
}
