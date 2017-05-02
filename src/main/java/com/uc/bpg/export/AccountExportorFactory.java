package com.uc.bpg.export;

import java.util.List;
import java.util.Map;

import com.uc.bpg.domain.Bill;
import com.uc.utils.export.Exportor;
import com.uc.utils.export.ExportorFactory;
import com.uc.utils.export.excel.IExcelExportOptions;
import com.uc.web.controller.ListController;

public class AccountExportorFactory implements ExportorFactory {

	@SuppressWarnings("unchecked")
	@Override
	public Exportor create(Map<String, Object> options) {
		return new AccountExportor((List<Bill>) options.get(ListController.EXPORTOR_OPTION_DATA), (IExcelExportOptions)options.get(ListController.EXPORTOR_OPTION_EXTERNAL));
	}

}
