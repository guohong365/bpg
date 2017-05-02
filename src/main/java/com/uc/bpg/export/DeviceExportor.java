package com.uc.bpg.export;

import java.util.List;

import com.uc.bpg.domain.Device;
import com.uc.utils.export.excel.ExcelColumnImpl;
import com.uc.utils.export.excel.ExcelSheetHeader;
import com.uc.utils.export.excel.IExcelExportOptions;
import com.uc.utils.export.excel.TableExportorBase;

public class DeviceExportor extends TableExportorBase<Device> {
	private static final String[] columns={
		"设备名称","设备型号","设备编号","有效","酒店","房间","状态"	
	};
	
	static class DeviceExportorHeader extends ExcelSheetHeader{
		private static final String DEFAULT_TITLE = "设备列表";

		public DeviceExportorHeader(IExcelExportOptions options) {
			super(options);
			setTitle(DEFAULT_TITLE);
			
			addSubColumn(new ExcelColumnImpl(columns[0]))
			.addSubColumn(new ExcelColumnImpl(columns[1]))
			.addSubColumn(new ExcelColumnImpl(columns[2]))
			.addSubColumn(new ExcelColumnImpl(columns[3]))
			.addSubColumn(new ExcelColumnImpl(columns[4]))
			.addSubColumn(new ExcelColumnImpl(columns[5]))
			.addSubColumn(new ExcelColumnImpl(columns[6]));
		}
		
	}
	
	public DeviceExportor(List<Device> data, IExcelExportOptions options) {
		super(new DeviceExportorHeader(options), data, options);		 
	}

	@Override
	public String getDefaultFileName() {
		return "设备列表.xls";
	}

	@Override
	protected String onGetColumnValue(int column, Device item) {
		switch(column){
		case 0:
			return item.getName();
		case 1:
			return item.getTypeName();
		case 2:
			return item.getSerialNo();
		case 3:
			return item.getValid()? "有效":"报废";
		case 4:
			return item.getHotelName();
		case 5:
			return item.getRoomNo();
		case 6:
			return item.getStatusDetail();
		}
		return "";
	}

	@Override
	protected int getColumnCount() {
		return 7;
	}

}
