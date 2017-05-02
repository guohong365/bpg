package com.uc.bpg.controller;

import org.springframework.ui.Model;

import com.uc.bpg.forms.StrategeQueryForm;

public interface StrategeController {			
	String getCurrent(Model model);
	String getListHistory(StrategeQueryForm queryForm, Model model);
}
