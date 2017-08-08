package com.uc.bpg.export;

import java.util.List;

import com.uc.bpg.domain.StatisticBill;
import com.uc.utils.export.excel.ExcelSheetHeader;
import com.uc.utils.export.excel.IExcelExportOptions;
import com.uc.utils.export.excel.TableExportorBase;

public class BackStatisticBillExportor extends TableExportorBase<StatisticBill> {

	public BackStatisticBillExportor(ExcelSheetHeader header, List<StatisticBill> data, IExcelExportOptions options) {
		super(header, data, options);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDefaultFileName() {
		return "账务统计.xls";
	}

	@Override
	protected String onGetColumnValue(int column, StatisticBill item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
