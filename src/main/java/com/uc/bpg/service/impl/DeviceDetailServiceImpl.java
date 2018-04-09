package com.uc.bpg.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.uc.bpg.domain.Device;
import com.uc.bpg.domain.Hotel;
import com.uc.bpg.domain.Room;
import com.uc.bpg.persistence.AllotHistoryMapper;
import com.uc.bpg.persistence.DeviceMapper;
import com.uc.bpg.persistence.HotelMapper;
import com.uc.bpg.persistence.RoomMapper;
import com.uc.bpg.service.DeviceDetailService;
import com.uc.web.service.AppDetailServiceBase;

public class DeviceDetailServiceImpl extends AppDetailServiceBase implements DeviceDetailService {
	private HotelMapper hotelMapper;
	private RoomMapper roomMapper;
	private AllotHistoryMapper allotHistoryMapper;
	
	public void setHotelMapper(HotelMapper hotelMapper) {
		this.hotelMapper = hotelMapper;
	}
	
	public HotelMapper getHotelMapper() {
		return hotelMapper;
	}
	
	public DeviceMapper getMapper(){
		return (DeviceMapper) super.getMapper();
	}
	
	public AllotHistoryMapper getAllotHistoryMapper() {
		return allotHistoryMapper;
	}
	
	public void setAllotHistoryMapper(AllotHistoryMapper allotHistoryMapper) {
		this.allotHistoryMapper = allotHistoryMapper;
	}
	
	public RoomMapper getRoomMapper() {
		return roomMapper;
	}
	public void setRoomMapper(RoomMapper roomMapper) {
		this.roomMapper = roomMapper;
	}

	@Override
	public void insertBatchAdd(List<Device> devices) {
		getMapper().insertBatchAdd(devices);
	}

	@Override
	public boolean selectExistsSerial(String serial) {
		return getMapper().selectExistsSerial(serial);
	}

	@Override
	public boolean selectAlreadyAllot(String serial, Long hotel) {
		return getMapper().selectAlreadyAllot(serial, hotel);
	}

	@Override
	public Hotel selectHotel(Long hotel) {
		return (Hotel) getHotelMapper().selectById(hotel);
	}

	@Override
	public void updateBatchAllot(List<Device> devices) {
		getMapper().updateBatchAllot(devices);
	}

	@Override
	public void updateBatchWithdraw(List<Device> devices) {
		getMapper().updateBatchWithdraw(devices);
	}

	@Override
	public void updateBatchScrap(List<Device> devices) {
		getMapper().updateBatchScrap(devices);
	}
	

	@Override
	public void updateAllot(Device device, String operatoin) {		
		getMapper().updateAllot(device, operatoin);
	}
	
	@Override
	public List<Room> selectAllocableRooms(Long hotelId) {
		return getMapper().selectAllocableRooms(hotelId);
	}
	
	

	@Override
	public int updateWithdrawAll(Long modifier, Long hotel) {		
		List<Device> devices=getMapper().selectAllocatedDevices(hotel);
		if(devices.isEmpty()) return 0;
		getMapper().updateWithdrawAll(devices, modifier);
		return devices.size();
	}

	@Override
	public int randomAllot(Long modifier, Long hotel) {
		List<Device> devices=getMapper().selectAllocableDevices(hotel);
		if(devices.isEmpty()) return 0;
		List<Room> rooms=getRoomMapper().selectUnallocatedRooms(hotel);
		if(rooms.isEmpty()) return 0;
		List<Device> allotDevice=new ArrayList<>();
		int indexDevice=0;
		int ok=0;
		for(int indexRoom=0; indexRoom<rooms.size(); indexRoom++){			
		  devices.get(indexDevice).setRoom(rooms.get(indexRoom).getId());
		  allotDevice.add(devices.get(indexDevice));
		  ok++;
		  indexDevice++;
		  if(indexDevice>=devices.size()-1)  break;
		}		
		getMapper().updateBatchAllot(allotDevice);
		return ok;
	}
}
