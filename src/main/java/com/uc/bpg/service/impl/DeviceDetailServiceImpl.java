package com.uc.bpg.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.uc.bpg.domain.Device;
import com.uc.bpg.domain.Hotel;
import com.uc.bpg.domain.Room;
import com.uc.bpg.persistence.AllotHistoryMapper;
import com.uc.bpg.persistence.DeviceMapper;
import com.uc.bpg.persistence.HotelMapper;
import com.uc.bpg.persistence.RoomMapper;
import com.uc.bpg.service.DeviceService;
import com.uc.web.persistence.Example;
import com.uc.web.persistence.ExampleImpl;
import com.uc.web.service.basic.GenericIntegerKeyAppDetailService;

public class DeviceDetailServiceImpl extends GenericIntegerKeyAppDetailService<Device> implements DeviceService {
	private HotelMapper hotelMapper;
	private RoomMapper roomMapper;
	private AllotHistoryMapper allotHistoryMapper;
	
	public void setHotelMapper(HotelMapper hotelMapper) {
		this.hotelMapper = hotelMapper;
	}
	
	public HotelMapper getHotelMapper() {
		return hotelMapper;
	}
	
	protected DeviceMapper getDeviceMapper(){
		return (DeviceMapper) getAppDetailMapper();
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
		getDeviceMapper().insertBatchAdd(devices);
	}

	@Override
	public boolean selectExistsSerial(String serial) {
		return getDeviceMapper().selectExistsSerial(serial);
	}

	@Override
	public boolean selectAlreadyAllot(String serial, Long hotel) {
		return getDeviceMapper().selectAlreadyAllot(serial, hotel);
	}

	@Override
	public Hotel selectHotel(Long hotel) {
		return getHotelMapper().selectById(hotel);
	}

	@Override
	public void updateBatchAllot(List<Device> devices) {
		getDeviceMapper().updateBatchAllot(devices);
	}

	@Override
	public void updateBatchWithdraw(List<Device> devices) {
		getDeviceMapper().updateBatchWithdraw(devices);
	}

	@Override
	public void updateBatchScrap(List<Device> devices) {
		getDeviceMapper().updateBatchScrap(devices);
	}
	

	@Override
	public void updateAllot(Device device, String operatoin) {		
		getDeviceMapper().updateAllot(device, operatoin);
	}
	
	@Override
	public List<Room> selectAllocableRooms(Long hotelId) {
		return getDeviceMapper().selectAllocableRooms(hotelId);
	}

	@Override
	public int updateWithdrawAll(Long modifier, Long hotel) {
		Example example=new ExampleImpl();
		example.or().andFieldEqualTo("HOTEL", hotel).andFieldIsNotNull("ROOM");
		long count=getDeviceMapper().selectCountByExample(example);
		List<Device> devices=getDeviceMapper().selectByExample(example, 0, count);
		if(devices.isEmpty()) return 0;
		Date date=Calendar.getInstance().getTime();
		for(Device device:devices){
			device.setModifier(modifier);
			device.setModifyTime(date);
		}
		getDeviceMapper().updateWithdrawAll(devices);
		return devices.size();
	}

	@Override
	public int randomAllot(Long modifier, Long hotel) {
		Example example=new ExampleImpl();
		example.or().andFieldEqualTo("HOTEL", hotel)
		.andFieldIsNull("ROOM").andFieldEqualTo("PUBLIC_USAGE", false);		
		Long count=getDeviceMapper().selectCountByExample(example);
		List<Device> devices=getDeviceMapper().selectByExample(example, 0, count);
		if(devices.isEmpty()) return 0;
		
		example.clear();
		example.or().andFieldEqualTo("HOTEL", hotel).andFieldIsNull("DEVICE");
		count=getRoomMapper().selectCountByExample(example);
		List<Room> rooms=getRoomMapper().selectByExample(example, 0, count);
		if(rooms.isEmpty()) return 0;
		List<Device> allotDevice=new ArrayList<>();
		int indexDevice=0;
		int ok=0;
		for(int indexRoom=0; indexRoom<rooms.size() && indexDevice< devices.size();indexRoom++){			
			while(indexDevice < devices.size()){
				if(!devices.get(indexDevice).getPublicUsage()){
					devices.get(indexDevice).setRoom(rooms.get(indexRoom).getId());
					allotDevice.add(devices.get(indexDevice));
					ok++;
					indexDevice++;					
					break;
				}
				indexDevice++;
			}
		}		
		getDeviceMapper().updateBatchAllot(allotDevice);
		return ok;
	}
}
