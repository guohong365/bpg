package com.uc.bpg.service;

import java.util.List;

import com.uc.bpg.domain.Charging;
import com.uc.bpg.domain.ChargingDetails;
import com.uc.bpg.domain.CheckIn;
import com.uc.bpg.domain.HotelRoomInfo;
import com.uc.bpg.domain.RoomDetail;

public interface ReceptionService {

	List<Integer> selectStoreys(Long hotelId);
	List<RoomDetail> selectRoomDetails(Long hotelId);
	Charging selectCharge(Long room);
	int insertCheckIn(CheckIn checkIn);
	int insertCheckOut(Charging charging);
	ChargingDetails selectChargingDetails(Long room);
	boolean selectRoomCanCheckIn(Long room);
	HotelRoomInfo selectHotelRoomInfo(Long hotel);
	
	

}
