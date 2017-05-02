package com.uc.bpg.controller.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.uc.bpg.controller.DeviceController;
import com.uc.bpg.domain.AllotHistory;
import com.uc.bpg.domain.Device;
import com.uc.bpg.forms.AllotHisQueryForm;
import com.uc.web.controller.DetailController;
import com.uc.web.controller.basic.AbstractIntegerKeyDetailListControllerProxy;
@Controller
@RequestMapping(value="${controller.proxy.uri.background.device}")
public class DeviceDetailListControllerProxy extends AbstractIntegerKeyDetailListControllerProxy<Device, AllotHisQueryForm, AllotHistory> implements DeviceController {
	
	@Value(value="${controller.proxy.uri.background.device}")
	private String baseUri;

	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}
	
	@Resource(name="${controller.impl.detail.background.device}")
	@Override
	public void setDetailController(DetailController<Long, Device> detailController) {
		super.setDetailController(detailController);
	}
	
	DeviceController getDeviceController(){		
		return (DeviceController) getDetailController();
	}

	@Override
	@RequestMapping(value="/batchFile", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	public String postBatchFile(
			@RequestParam(value=PARAM_NAME_ACTION)
			String action,
			@RequestParam(value="param", required=false)
			Long param,
			@RequestParam(value="batchFile")
			MultipartFile file) {		
		return getDeviceController().postBatchFile(action,param, file);
	}
	
}
