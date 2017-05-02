package com.uc.bpg.export;

import java.util.List;
import java.util.Map;

import com.uc.bpg.domain.Device;
import com.uc.utils.export.Exportor;
import com.uc.utils.export.ExportorFactory;
import com.uc.utils.export.excel.IExcelExportOptions;
import com.uc.web.controller.ListController;

public class DeviceExportorFactory implements ExportorFactory {
	@Override
	public Exportor create(Map<String, Object> options) {
		@SuppressWarnings("unchecked")
		List<Device> data=(List<Device>) options.get(ListController.EXPORTOR_OPTION_DATA);
		IExcelExportOptions opts=(IExcelExportOptions) options.get(ListController.EXPORTOR_OPTION_EXTERNAL);
		return new DeviceExportor(data, opts);
	}

}
