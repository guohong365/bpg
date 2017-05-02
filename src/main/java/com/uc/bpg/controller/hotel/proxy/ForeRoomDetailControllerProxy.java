package com.uc.bpg.controller.hotel.proxy;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uc.bpg.controller.RoomDetailController;
import com.uc.bpg.domain.Room;
import com.uc.web.controller.DetailController;
import com.uc.web.controller.basic.AbstractIntegerKeyDetailControllerProxy;

@Controller
@RequestMapping("${controller.proxy.uri.hotel.room}")
public class ForeRoomDetailControllerProxy extends AbstractIntegerKeyDetailControllerProxy<Room> implements RoomDetailController{

	@Value("${controller.proxy.uri.hotel.room}")
	private String baseUri;

	@Override
	protected String onGetBaseUri() {
		return baseUri;
	}
	
	@Resource(name="${controller.impl.detail.hotel.room}")
	@Override
	public void setDetailController(DetailController<Long, Room> detailController) {
		super.setDetailController(detailController);
	}
	
	RoomDetailController getRoomDetailController(){
		return (RoomDetailController) getDetailController();
	}

	@Override
	@RequestMapping(value="/batchAdd", method=RequestMethod.POST, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String postBatchAdd(
			@RequestParam(value="storey", required=true)
			Integer storey,
			@RequestParam(value="pattern", required=true)
			String pattern,
			@RequestParam(value="begin", required=true)
			Integer begin,
			@RequestParam(value="end", required=true)
			Integer end,
			@RequestParam(value="ignoreDuplicated", required=false, defaultValue="false")
			Boolean ignoreDuplicated
			) {
		return getRoomDetailController().postBatchAdd(storey, pattern, begin, end, ignoreDuplicated);
	}

}
