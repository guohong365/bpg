package com.uc.bpg.controller;

import com.uc.bpg.domain.Room;
import com.uc.web.controller.basic.IntegerKeyDetailController;


public interface RoomDetailController extends IntegerKeyDetailController<Room>{
	String postBatchAdd(Integer storey, String pattern, Integer begin, Integer end, Boolean ignoreDuplicated);
}
