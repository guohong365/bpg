package com.uc.bpg.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uc.bpg.domain.Charging;
import com.uc.bpg.domain.ChargingDetails;
import com.uc.bpg.domain.CheckIn;
import com.uc.bpg.domain.HotelRoomInfo;
import com.uc.bpg.domain.RoomDetail;
import com.uc.bpg.persistence.ChargingMapper;
import com.uc.bpg.persistence.CheckInMapper;
import com.uc.bpg.persistence.ReceptionMapper;
import com.uc.bpg.service.ReceptionService;
import com.uc.bpg.uitls.OptResult;

public class ReceptionServiceImpl implements ReceptionService {
	private Logger logger;
	private ReceptionMapper receptionMapper;
	private CheckInMapper checkInMapper;
	private ChargingMapper chargingMapper;
	
	public ReceptionServiceImpl(){
		logger=LoggerFactory.getLogger(getClass());
	}
	
	protected Logger getLogger(){
		return logger;
	}
	
	public ReceptionMapper getReceptionMapper() {
		return receptionMapper;
	}
	
	public void setReceptionMapper(ReceptionMapper receptionMapper) {
		this.receptionMapper = receptionMapper;
	}
	
	public void setCheckInMapper(CheckInMapper checkInMapper) {
		this.checkInMapper = checkInMapper;
	}
	public CheckInMapper getCheckInMapper() {
		return checkInMapper;
	}
	public void setChargingMapper(ChargingMapper chargingMapper) {
		this.chargingMapper = chargingMapper;
	}
	public ChargingMapper getChargingMapper() {
		return chargingMapper;
	}

	@Override
	public List<Integer> selectStoreys(Long hotelId) {
		return getReceptionMapper().selectStoreys(hotelId);
	}

	@Override
	public List<RoomDetail> selectRoomDetails(Long hotelId) {
		return getReceptionMapper().selectRoomDetails(hotelId);
	}
	
	@Override
	public HotelRoomInfo selectHotelRoomInfo(Long hotel){
		HotelRoomInfo info=new HotelRoomInfo();
		info.setStoreys(selectStoreys(hotel));
		info.setRooms(selectRoomDetails(hotel));
		return info;
	}

	@Override
	public Charging selectCharge(Long room) {
		return getReceptionMapper().selectCharge(room);
	}

	@Override
	public int insertCheckIn(CheckIn checkIn) {
		return getReceptionMapper().insertCheckIn(checkIn);
	}

	@Override
	public int insertCheckOut(Charging charging) {
		return getReceptionMapper().insertCheckOut(charging);
	}

	@Override
	public boolean selectRoomCanCheckIn(Long room) {
		return getReceptionMapper().selectRoomCanCheckIn(room);
	}

	@Override
	public ChargingDetails selectChargingDetails(Long room) {
		return getReceptionMapper().selectChargingDetails(room);
	}

	@Override
	public OptResult<Charging> selectRoomCheckOut(Long hotel, String roomNo) {
		CheckIn roomCheckIn=getReceptionMapper().selectRoomCheckIn(hotel, roomNo);
		OptResult<Charging> result=new OptResult<>(hotel, roomNo);
		if(roomCheckIn==null){
			result.setOk(false);
			result.setReason("房间不存在！");
		} else if(roomCheckIn.getId()==null || roomCheckIn.getCheckOutTime()!=null){
			result.setOk(false);
			result.setReason("房间没有入住记录！");
		} else {
			Charging charging=getReceptionMapper().selectCharge(roomCheckIn.getRoom());
			result.setData(charging);
			result.setOk(true);
		}
		return result;
	}

	@Override
	public OptResult<CheckIn> selectRoomCheckIn(Long hotel, String roomNo) {
		OptResult<CheckIn> result=new OptResult<>(hotel, roomNo);
		CheckIn checkIn=getReceptionMapper().selectRoomCheckIn(hotel, roomNo);
		
		if(checkIn!=null){
			getLogger().debug(checkIn.toString());
			result.setData(checkIn);
			result.setRoom(checkIn.getRoom());
			if(checkIn.getId()==null || checkIn.getCheckOutTime()!=null){
				result.setReason("");
				result.setOk(true);
			} else {
				result.setOk(false);
				result.setReason("房间已入住！");
			}
		} else {
			result.setData(null);
			result.setOk(false);
			result.setReason("房间不存在！");
		}
		return result;
	}
	
}
