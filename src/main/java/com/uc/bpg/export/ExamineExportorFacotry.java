package com.uc.bpg.export;

import java.util.List;
import java.util.Map;

import com.uc.bpg.domain.Examine;
import com.uc.utils.export.Exportor;
import com.uc.utils.export.ExportorFactory;
import com.uc.utils.export.excel.IExcelExportOptions;
import com.uc.web.controller.ListController;

public class ExamineExportorFacotry implements ExportorFactory {

	@Override
	public Exportor create(Map<String, Object> options) {
		@SuppressWarnings("unchecked")
		List<Examine> data=(List<Examine>) options.get(ListController.EXPORTOR_OPTION_DATA);
		IExcelExportOptions opt=(IExcelExportOptions) options.get(ListController.EXPORTOR_OPTION_EXTERNAL);		
		return new ExamineExportor(data, opt);
	}

}
