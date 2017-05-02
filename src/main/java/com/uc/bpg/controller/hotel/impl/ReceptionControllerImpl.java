package com.uc.bpg.controller.hotel.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.uc.bpg.domain.Charging;
import com.uc.bpg.domain.ChargingDetails;
import com.uc.bpg.domain.CheckIn;
import com.uc.bpg.domain.HotelRoomInfo;
import com.uc.bpg.domain.RoomDetail;
import com.uc.bpg.service.ReceptionService;
import com.uc.web.controller.ControllerProxySupportImpl;

@Controller
@RequestMapping("/hotel/reception")
public class ReceptionControllerImpl  extends ControllerProxySupportImpl<Long> {
	
	private static final String RECEPTION_PAGE = "/hotel/reception/main";

	private static final String PARAM_NAME_STOREYS = "_storeys";

	private static final String PARAM_NAME_ROOM_DETAILS = "_roomDetails";

	private static final String PARAM_NAME_CHARGE = "_charging";

	private static final String PARAM_NAME_CHARGING_DETAILS = "_chargingDetails";
	
	private static SerializeConfig mapping=new SerializeConfig();
	private static String dateFormat="yyyy-MM-dd HH:mm:ss";
	private static SerializerFeature[] features={
			SerializerFeature.WriteMapNullValue,
			SerializerFeature.WriteNullBooleanAsFalse,
			SerializerFeature.WriteNullListAsEmpty,
			SerializerFeature.WriteNullNumberAsZero,
			SerializerFeature.WriteNullStringAsEmpty
	};
	static {
		mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
	}

	@Resource(name="${service.reception}")
	private ReceptionService service;
	
	public ReceptionService getService() {
		return service;
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getReceptionPage(Model model){
		Long hotelId=getUserProfile().getOrgnization().getId();
		List<Integer> storeies=getService().selectStoreys(hotelId);
		model.addAttribute(PARAM_NAME_STOREYS, storeies);
		List<RoomDetail> roomDetails=getService().selectRoomDetails(hotelId);
		model.addAttribute(PARAM_NAME_ROOM_DETAILS, roomDetails);
		model.addAttribute("userName",getUserProfile().getOrgnization().getName() +" " + getUserProfile().getUser().getName());
		return RECEPTION_PAGE;
	}
	
	@RequestMapping(value="/checkin", method=RequestMethod.GET)
	@ResponseBody
	public String getCheckIn(
		@RequestParam("room")
		Long room,
		Model model){		
		return getService().selectRoomCanCheckIn(room)? "OK": "FAILED";
	}
	@RequestMapping(value="checkin", method=RequestMethod.POST)
	@ResponseBody
	public String postCheckIn(
			Long room,
			Model model
			){
		CheckIn checkIn=new CheckIn();
		checkIn.setCheckInReceptionist(getUserProfile().getUser().getId());
		checkIn.setCheckInTime(Calendar.getInstance().getTime());
		checkIn.setHotel(getUserProfile().getOrgnization().getId());
		checkIn.setRoom(room);
		checkIn.setUuid(UUID.randomUUID().toString());
		return getService().insertCheckIn(checkIn)==1 ?"OK":"ERROR";
	}
	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public String getCharge(
			Long room,
			Model model
			){
		Charging charging= getService().selectCharge(room);		
		model.addAttribute(PARAM_NAME_CHARGE, charging);
		return getPageBasePath() + "/checkout";
	}
	
	@RequestMapping(value="/checkout", method=RequestMethod.POST)
	public String postCharge(
			@ModelAttribute(PARAM_NAME_CHARGE)
			Charging charging, 
			Model model){
		charging.setReceptionist(getUserProfile().getOrgnization().getId());
		charging.setChargingTime(Calendar.getInstance().getTime());
		return getService().insertCheckOut(charging)==1? "OK":"ERROR";
	}
	
	@RequestMapping(value="/details", method=RequestMethod.GET)
	public String getDetails(Long room, Model model){
		ChargingDetails chargingDetails= getService().selectChargingDetails(room);
		model.addAttribute(PARAM_NAME_CHARGING_DETAILS, chargingDetails);
		return getPageBasePath() + "/details";
	}
	
	@RequestMapping(value="/rooms", method=RequestMethod.POST, produces="application/json;charset=UTF-8;")
	@ResponseBody
	public String postLoadRooms(){
		HotelRoomInfo info= getService().selectHotelRoomInfo(getUserProfile().getOrgnization().getId());
		return JSON.toJSONString(info, mapping, features);
	}
	
	
	
	
}
