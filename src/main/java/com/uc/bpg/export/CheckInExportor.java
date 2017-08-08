package com.uc.bpg.export;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import com.uc.bpg.domain.CheckIn;
import com.uc.bpg.forms.CheckInQueryForm;
import com.uc.utils.export.excel.ExcelColumnImpl;
import com.uc.utils.export.excel.ExcelSheetHeader;
import com.uc.utils.export.excel.IExcelExportOptions;
import com.uc.utils.export.excel.TableExportorBase;

public class CheckInExportor extends TableExportorBase<CheckIn> {
	private static final String[] columns={
		"房间号","入住时间","退房时间","使用次数","收费","入住登记人","退房结算人"
	};
	
	private static class Header extends ExcelSheetHeader{
		@SuppressWarnings("unused")
		private CheckInQueryForm queryForm;
		public Header(CheckInQueryForm queryForm, IExcelExportOptions options){
			super(options);
			this.queryForm=queryForm;
			setTitle("入住记录");
			addSubColumn(new ExcelColumnImpl(columns[0]))
			.addSubColumn(new ExcelColumnImpl(columns[1]))
			.addSubColumn(new ExcelColumnImpl(columns[2]))
			.addSubColumn(new ExcelColumnImpl(columns[3]))
			.addSubColumn(new ExcelColumnImpl(columns[4]))
			.addSubColumn(new ExcelColumnImpl(columns[5]))
			.addSubColumn(new ExcelColumnImpl(columns[6]));
		}
	}

	public CheckInExportor(CheckInQueryForm queryForm, List<CheckIn> data, IExcelExportOptions options) {
		super(new Header(queryForm, options), data, options);
	}

	@Override
	public String getDefaultFileName() {
		return "入住记录";
	}

	@Override
	protected String onGetColumnValue(int column, CheckIn item) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		switch(column){
		case 0:
			return item.getRoomNo();
		case 1:
			return item.getCheckInTime()==null ?"":dateFormat.format(item.getCheckInTime());
		case 2:
			return item.getCheckOutTime()==null?"":dateFormat.format(item.getCheckOutTime());
		case 3:
			return item.getUseTimes().toString();
		case 4:
			return item.getCharge().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		case 5:
			return item.getCheckInReceptionistName();
		case 6:	
			return item.getCheckOutReceptionistName()==null?"":item.getCheckOutReceptionistName();
		default:
			return "";
		}
	}

	@Override
	protected int getColumnCount() {
		return 7;
	}

}
