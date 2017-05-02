package com.uc.bpg.export;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.util.StringUtils;

import com.uc.bpg.domain.AllotHistory;
import com.uc.bpg.domain.Device;
import com.uc.bpg.forms.AllotHisQueryForm;
import com.uc.utils.export.excel.ExcelColumnImpl;
import com.uc.utils.export.excel.ExcelHelper;
import com.uc.utils.export.excel.ExcelSheetHeader;
import com.uc.utils.export.excel.IExcelExportOptions;
import com.uc.utils.export.excel.TableExportorBase;

public class AllotHistoryExportor extends TableExportorBase<AllotHistory> {
	
	private static final String DEFAULT_NAME = "设备分配历史[%s].xls";
	
	private String fileName;

	public AllotHistoryExportor(AllotHisQueryForm queryForm, Device detail, List<AllotHistory> data, IExcelExportOptions options) {
		super(new AllotHistoryExportorHeader(queryForm, detail, options), data, options);
		fileName=String.format(DEFAULT_NAME, detail==null?"":detail.getSerialNo());
	}

	@Override
	public String getDefaultFileName() {
		return fileName;
	}

	@Override
	protected String onGetColumnValue(int column, AllotHistory item) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
		switch(column){
		case 0:
			return format.format(item.getOperateTime());
		case 1:
			return item.getOperation();
		case 2:
			return item.getHotelName()==null?"":item.getHotelName();
		case 3:
			return item.getRoomNo()==null ?"":item.getRoomNo();
		case 4:
			return item.getOperaterName()==null?"":item.getOperaterName();
		}
		return "";
	}
	
	@Override
	protected int getColumnCount() {
		return 5;
	}
	
	static class AllotHistoryExportorHeader extends ExcelSheetHeader{
		private static final String[] columns={
			"操作时间","操作","酒店","房间","操作人"	
		};
		private static final String SHEET_TITLE = "设备分配历史";
		private AllotHisQueryForm queryForm;
		private Device device;		
		public AllotHistoryExportorHeader(AllotHisQueryForm queryForm, Device device, IExcelExportOptions options){
			super(options);
			setTitle(SHEET_TITLE);
			this
			.addSubColumn(new ExcelColumnImpl(columns[0]))
			.addSubColumn(new ExcelColumnImpl(columns[1]))
			.addSubColumn(new ExcelColumnImpl(columns[2]))
			.addSubColumn(new ExcelColumnImpl(columns[3]))
			.addSubColumn(new ExcelColumnImpl(columns[4]));
			this.queryForm=queryForm;
			this.device=device;
		}
		@Override
		protected int exprotAddtional(Sheet sheet, int beginRow, int startCol) {
			if(device==null) return super.exprotAddtional(sheet, beginRow, startCol);
			beginRow=super.exprotAddtional(sheet, beginRow, startCol);
			int width=5;
			int begin=beginRow;
			Row row=sheet.createRow(beginRow);
			beginRow++;
			Cell cell=row.createCell(startCol,CellType.STRING);
			cell.setCellValue("设备名称：");
			cell=row.createCell(startCol+1,CellType.STRING);
			cell.setCellValue(device.getName());
			cell=row.createCell(startCol+3,CellType.STRING);
			cell.setCellValue("设备型号：");
			cell=row.createCell(startCol, CellType.STRING);
			cell.setCellValue(device.getTypeName());
			row=sheet.createRow(beginRow);
			beginRow ++;
			cell=row.createCell(startCol, CellType.STRING);
			cell.setCellValue("设备编号：");
			cell=row.createCell(startCol+1, CellType.STRING);
			cell.setCellValue(device.getSerialNo());
			cell=row.createCell(startCol+3, CellType.STRING);
			cell.setCellValue("状态：");
			cell=row.createCell(startCol+4, CellType.STRING);
			cell.setCellValue(device.getStatusDetail());
			row=sheet.createRow(beginRow);
			beginRow ++;
			cell=row.createCell(startCol, CellType.STRING);
			cell.setCellValue("酒店：");
			cell=row.createCell(startCol+1, CellType.STRING);
			cell.setCellValue(device.getHotelName()==null?"":device.getHotelName());
			cell=row.createCell(startCol+3, CellType.STRING);
			cell.setCellValue("房间：");
			cell=row.createCell(startCol+4, CellType.STRING);
			cell.setCellValue(device.getRoomNo()==null?"":device.getRoomNo());
						
			CellRangeAddress range=new CellRangeAddress(begin, begin+2, startCol, startCol+width-1);
			ExcelHelper.setRegionBorder(sheet, range, BorderStyle.THIN);
			row=sheet.createRow(beginRow);
			beginRow ++;
			cell=row.createCell(startCol,CellType.STRING);
			cell.setCellValue("查询条件");
			range.setFirstRow(begin+3);
			range.setLastRow(begin +3);
			sheet.addMergedRegion(range);
			ExcelHelper.setRegionBorder(sheet, range, BorderStyle.THIN);
			if(queryForm==null) return beginRow;
			
			SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
			begin=beginRow;
			row=sheet.createRow(beginRow);
			beginRow ++;
			cell=row.createCell(startCol,CellType.STRING);
			cell.setCellValue(String.format("操作时间：%s至%s",
				queryForm.getQueryOperateTimeFrom()==null?"":format.format(queryForm.getQueryOperateTimeFrom()), 
				queryForm.getQueryOperateTimeTo()==null?"":format.format(queryForm.getQueryOperateTimeTo())));
			range.setFirstRow(begin);
			range.setLastRow(begin);
			sheet.addMergedRegion(range);
			ExcelHelper.setRegionBorder(sheet, range, BorderStyle.THIN);
			begin=beginRow;
			row=sheet.createRow(beginRow);
			beginRow ++;
			cell=row.createCell(startCol,CellType.STRING);
			cell.setCellValue("操作："+ (StringUtils.isEmpty(queryForm.getQueryOperation())?"全部":queryForm.getQueryOperation()));			
			range.setFirstRow(begin);
			range.setLastRow(begin);
			sheet.addMergedRegion(range);
			ExcelHelper.setRegionBorder(sheet, range, BorderStyle.THIN);
			begin=beginRow;
			row=sheet.createRow(beginRow);
			beginRow ++;
			cell=row.createCell(startCol,CellType.STRING);
			cell.setCellValue("酒店："+ (StringUtils.isEmpty(queryForm.getQueryHotelName())?"全部":queryForm.getQueryHotelName()));			
			range.setFirstRow(begin);
			range.setLastRow(begin);
			sheet.addMergedRegion(range);
			ExcelHelper.setRegionBorder(sheet, range, BorderStyle.THIN);
			begin=beginRow;
			row=sheet.createRow(beginRow);
			beginRow ++;
			cell=row.createCell(startCol,CellType.STRING);
			cell.setCellValue("房间："+ (StringUtils.isEmpty(queryForm.getQueryRoom())?"全部":queryForm.getQueryRoom()));			
			range.setFirstRow(begin);
			range.setLastRow(begin);
			sheet.addMergedRegion(range);
			ExcelHelper.setRegionBorder(sheet, range, BorderStyle.THIN);
			begin=beginRow;
			row=sheet.createRow(beginRow);
			beginRow ++;
			cell=row.createCell(startCol,CellType.STRING);
			cell.setCellValue("操作人："+ (StringUtils.isEmpty(queryForm.getQueryOperaterName())?"全部":queryForm.getQueryOperaterName()));			
			range.setFirstRow(begin);
			range.setLastRow(begin);
			sheet.addMergedRegion(range);			
			ExcelHelper.setRegionBorder(sheet, range, BorderStyle.THIN);
			return beginRow;
		}
	}

}
