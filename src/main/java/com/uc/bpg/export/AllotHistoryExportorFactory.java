package com.uc.bpg.export;

import java.util.List;
import java.util.Map;

import com.uc.bpg.domain.AllotHistory;
import com.uc.bpg.domain.Device;
import com.uc.bpg.forms.AllotHisQueryForm;
import com.uc.utils.export.Exportor;
import com.uc.utils.export.ExportorFactory;
import com.uc.utils.export.excel.IExcelExportOptions;
import com.uc.web.controller.DetailListController;

public class AllotHistoryExportorFactory implements ExportorFactory {

	@SuppressWarnings("unchecked")
	@Override
	public Exportor create(Map<String, Object> options) {
		return new AllotHistoryExportor(
				(AllotHisQueryForm)options.get(DetailListController.EXPORTOR_OPTION_QUERY_FORM),
				(Device)options.get(DetailListController.EXPORTOR_OPTION_DETAIL_DATA),
				(List<AllotHistory>)options.get(DetailListController.EXPORTOR_OPTION_DATA),
				(IExcelExportOptions)options.get(DetailListController.EXPORTOR_OPTION_EXTERNAL));
	}

}
