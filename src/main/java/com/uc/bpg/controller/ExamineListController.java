package com.uc.bpg.controller;

import com.uc.bpg.domain.Examine;
import com.uc.bpg.forms.ExamineQueryForm;
import com.uc.web.controller.basic.IntegerKeyListController;

public interface ExamineListController extends IntegerKeyListController<ExamineQueryForm, Examine> {

}
