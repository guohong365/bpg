package com.uc.bpg.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uc.bpg.domain.Room;
import com.uc.web.persistence.AppInsertMapper;
import com.uc.web.persistence.AppOptimizedMapper;
import com.uc.web.persistence.AppSelectByKeyMapper;
import com.uc.web.persistence.AppUpdateMapper;

public interface RoomMapper extends AppInsertMapper, AppUpdateMapper, AppSelectByKeyMapper, AppOptimizedMapper{

	boolean selectExistsRoom(
			@Param("hotel")
			Long hotel,
			@Param("storey")
			Integer storey,
			@Param("room")
			String roomNo);

	void insertBatch(
			@Param("rooms")
			List<Room> rooms);

	List<Room> selectUnallocatedRooms(@Param("hotel")Long hotel);
}