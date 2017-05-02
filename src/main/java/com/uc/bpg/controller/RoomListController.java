package com.uc.bpg.controller;

import com.uc.bpg.domain.Room;
import com.uc.bpg.forms.RoomQueryForm;
import com.uc.web.controller.basic.IntegerKeyListController;


public interface RoomListController extends IntegerKeyListController<RoomQueryForm,Room>{
}
