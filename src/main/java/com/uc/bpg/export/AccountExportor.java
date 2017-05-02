package com.uc.bpg.export;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import com.uc.bpg.domain.Bill;
import com.uc.utils.export.excel.ExcelColumnImpl;
import com.uc.utils.export.excel.ExcelSheetHeader;
import com.uc.utils.export.excel.IExcelExportOptions;
import com.uc.utils.export.excel.TableExportorBase;

public class AccountExportor extends TableExportorBase<Bill>{

	private static final String DEFALT_FILE_NAME = "账单.xls";

	public AccountExportor(List<Bill> data, IExcelExportOptions options) {
		super(new AccountExportorHeader(options), data, options);
	}

	@Override
	public String getDefaultFileName() {
		return DEFALT_FILE_NAME;
	}

	@Override
	protected String onGetColumnValue(int column, Bill item) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		switch(column){
		case 0:
			return format.format(item.getGeneratedTime());
		case 1:
			return item.getHotelName();
		case 2:
			return item.getIncome().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		case 3:	
			return item.getPayable().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		case 4:
			return item.getRatio().multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP).toString()+"%";
		case 5:
			return item.getState();
		case 6:
			return format.format(item.getPayTime());
		case 7:
			return item.getPayerName();
		case 8:
			return format.format(item.getVerifyTime());
		case 9:
			return item.getVerifierName();
		}
		return "";
	}

	@Override
	protected int getColumnCount() {
		return 10;
	}
	static class AccountExportorHeader extends ExcelSheetHeader {
		private static final String[] columns={
				"生成时间","酒店","酒店收入","应付款","分成比例","付款状态","付款时间","付款人","确认时间","确认人"	
			};		
		private static final String DEFAULT_TITLE = "账单";

		public AccountExportorHeader(IExcelExportOptions options) {
			super(options);
			setTitle(DEFAULT_TITLE);
			this
			.addSubColumn(new ExcelColumnImpl(columns[0]))
			.addSubColumn(new ExcelColumnImpl(columns[1]))
			.addSubColumn(new ExcelColumnImpl(columns[2]))
			.addSubColumn(new ExcelColumnImpl(columns[3]))
			.addSubColumn(new ExcelColumnImpl(columns[4]))
			.addSubColumn(new ExcelColumnImpl(columns[5]))
			.addSubColumn(new ExcelColumnImpl(columns[6]))
			.addSubColumn(new ExcelColumnImpl(columns[7]))
			.addSubColumn(new ExcelColumnImpl(columns[8]))
			.addSubColumn(new ExcelColumnImpl(columns[9]));
		}
	}
}
