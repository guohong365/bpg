package com.uc.bpg.persistence;

import java.util.List;

import com.uc.bpg.domain.Charging;
import com.uc.bpg.domain.ChargingDetails;
import com.uc.bpg.domain.CheckIn;
import com.uc.bpg.domain.RoomDetail;

public interface ReceptionMapper {

	List<Integer> selectStoreys(Long hotelId);

	List<RoomDetail> selectRoomDetails(Long hotelId);

	Charging selectCharge(Long room);

	int insertCheckIn(CheckIn checkIn);

	int insertCheckOut(Charging charging);

	boolean selectRoomCanCheckIn(Long room);

	ChargingDetails selectChargingDetails(Long room);

}
