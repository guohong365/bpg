package com.uc.bpg.forms;

public class DetailListQueryForm extends QueryFormBase implements IDetailListQueryForm {
	private Long querySelectedId;
	public void setQuerySelectedId(Long querySelectedId) {
		this.querySelectedId = querySelectedId;
	}
	public Long getQuerySelectedId() {
		return querySelectedId;
	}
}
