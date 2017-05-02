package com.uc.bpg.service;

import com.uc.bpg.domain.Room;
import com.uc.bpg.forms.RoomQueryForm;
import com.uc.web.service.basic.IntegerKeyAppListService;


public interface RoomListService extends IntegerKeyAppListService<RoomQueryForm,Room>{
}
