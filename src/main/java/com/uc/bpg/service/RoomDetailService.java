package com.uc.bpg.service;

import java.util.List;

import com.uc.bpg.domain.Room;
import com.uc.web.service.AppDetailService;


public interface RoomDetailService extends AppDetailService<Long, Room>{

	boolean selectExistsRoom(Long hotel, Integer storey, String roomNo);

	void insertBatch(List<Room> rooms);
}
