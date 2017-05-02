package com.uc.bpg.export;

import java.math.BigDecimal;
import java.util.List;

import com.uc.bpg.domain.Hotel;
import com.uc.utils.export.excel.ExcelColumnImpl;
import com.uc.utils.export.excel.ExcelSheetHeader;
import com.uc.utils.export.excel.IExcelExportOptions;
import com.uc.utils.export.excel.TableExportorBase;

public class HotelExportor extends TableExportorBase<Hotel> {
	private static final String[] columns={
		"酒店","设备总数","公用总数","已拥有","结算标准","分成比例","结算周期","酒店收费","地址","联系人","电话","备注"	
	};
	private static final String DEFAULT_FILE_NAME = "酒店清单.xls";
	static class HotelExportorHeader extends ExcelSheetHeader{
		private static final String DEFAULT_TITLE = "酒店清单";

		public HotelExportorHeader(IExcelExportOptions options) {
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
			.addSubColumn(new ExcelColumnImpl(columns[9]))
			.addSubColumn(new ExcelColumnImpl(columns[10]))
			.addSubColumn(new ExcelColumnImpl(columns[11]));
		}
	}

	public HotelExportor(List<Hotel> data, IExcelExportOptions options) {
		super(new HotelExportorHeader(options), data, options);
	}

	@Override
	public String getDefaultFileName() {
		return DEFAULT_FILE_NAME;
	}

	@Override
	protected String onGetColumnValue(int column, Hotel item) {
		switch(column){
		case 0:
			return item.getName();
		case 1:
			return item.getTotalDevice().toString();
		case 2:
			return item.getPublicUsage().toString();
		case 3:
			return item.getOwnedDevice().toString();
		case 4:
			return item.getChargeStandard().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		case 5:			
			return item.getRatio().multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP).toString()+ "%";
		case 6:
			return item.getBillingCycleString();
		case 7:
			return item.getCharge().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		case 8:			
			return item.getAddress()==null ? "":item.getAddress();
		case 9:
			return item.getLinkman()==null?"":item.getLinkman();
		case 10:
			return item.getTele()==null?"":item.getTele();
		case 11:			
			return item.getDescription()==null?"":item.getDescription();
		}
		return "";
	}

	@Override
	protected int getColumnCount() {
		return 12;
	}

}
