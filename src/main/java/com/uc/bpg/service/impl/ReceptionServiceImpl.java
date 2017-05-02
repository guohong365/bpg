package com.uc.bpg.service.impl;

import java.util.List;

import com.uc.bpg.domain.Charging;
import com.uc.bpg.domain.ChargingDetails;
import com.uc.bpg.domain.CheckIn;
import com.uc.bpg.domain.HotelRoomInfo;
import com.uc.bpg.domain.RoomDetail;
import com.uc.bpg.persistence.ChargingMapper;
import com.uc.bpg.persistence.CheckInMapper;
import com.uc.bpg.persistence.ReceptionMapper;
import com.uc.bpg.service.ReceptionService;

public class ReceptionServiceImpl implements ReceptionService {
	
	private ReceptionMapper receptionMapper;
	private CheckInMapper checkInMapper;
	private ChargingMapper chargingMapper;
	
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
	
}
