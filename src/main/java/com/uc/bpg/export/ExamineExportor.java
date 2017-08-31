package com.uc.bpg.export;

import java.text.SimpleDateFormat;
import java.util.List;

import com.uc.bpg.domain.Examine;
import com.uc.utils.export.excel.ExcelColumnImpl;
import com.uc.utils.export.excel.ExcelSheetHeader;
import com.uc.utils.export.excel.IExcelExportOptions;
import com.uc.utils.export.excel.TableExportorBase;

public class ExamineExportor extends TableExportorBase<Examine>{
	private static final String[] columns={"MAC","状态","接收时间","数据"};
	
	private static class Header extends ExcelSheetHeader{
		public Header(IExcelExportOptions options)
		{
			super(options);
			setTitle("数据接收记录");
			addSubColumn(new ExcelColumnImpl(columns[0]))
			.addSubColumn(new ExcelColumnImpl(columns[1]))
			.addSubColumn(new ExcelColumnImpl(columns[2]))
			.addSubColumn(new ExcelColumnImpl(columns[3]));
		}
	}

	public ExamineExportor(List<Examine> data, IExcelExportOptions options) {
		super(new Header(options), data, options);
	}

	@Override
	public String getDefaultFileName() {
		return "数据接收记录.xls";
	}

	@Override
	protected String onGetColumnValue(int column, Examine item) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		switch(column){
		case 0:
			return item.getMac();
		case 1:
			return item.getStatus().toString();
		case 2:
			return format.format(item.getRecvTime());
		case 3:
			return item.getData();
		}
		return null;
	}

	@Override
	protected int getColumnCount() {
		return 4;
	}

}
