package com.uc.bpg.forms;

import java.util.Date;
import java.util.Map;


public class CheckInQueryForm  extends QueryFormBase {
	private String queryRoomNo;
	private Date queryCheckInTimeFrom;
	private Date queryCheckInTimeTo;
	private Date queryCheckOutTimeFrom;
	private Date queryCheckOutTimeTo;
	private String queryCheckInReceptionistName;
	private String queryCheckOutReceptionistName;
	private Date queryNow;
	public String getQueryRoomNo() {
		return queryRoomNo;
	}
	public void setQueryRoomNo(String queryRoomNo) {
		this.queryRoomNo = queryRoomNo;
	}
	public Date getQueryCheckInTimeFrom() {
		return queryCheckInTimeFrom;
	}
	public void setQueryCheckInTimeFrom(Date queryCheckInTimeFrom) {
		this.queryCheckInTimeFrom = queryCheckInTimeFrom;
	}
	public Date getQueryCheckInTimeTo() {
		return queryCheckInTimeTo;
	}
	public void setQueryCheckInTimeTo(Date queryCheckInTimeTo) {
		this.queryCheckInTimeTo = queryCheckInTimeTo;
	}
	public Date getQueryCheckOutTimeFrom() {
		return queryCheckOutTimeFrom;
	}
	public void setQueryCheckOutTimeFrom(Date queryCheckOutTimeFrom) {
		this.queryCheckOutTimeFrom = queryCheckOutTimeFrom;
	}
	public Date getQueryCheckOutTimeTo() {
		return queryCheckOutTimeTo;
	}
	public void setQueryCheckOutTimeTo(Date queryCheckOutTimeTo) {
		this.queryCheckOutTimeTo = queryCheckOutTimeTo;
	}
	public String getQueryCheckInReceptionistName() {
		return queryCheckInReceptionistName;
	}
	public void setQueryCheckInReceptionistName(String queryCheckInReceptionistName) {
		this.queryCheckInReceptionistName = queryCheckInReceptionistName;
	}
	public String getQueryCheckOutReceptionistName() {
		return queryCheckOutReceptionistName;
	}
	public void setQueryCheckOutReceptionistName(String queryCheckOutReceptionistName) {
		this.queryCheckOutReceptionistName = queryCheckOutReceptionistName;
	}
	public Date getQueryNow() {
		return queryNow;
	}
	public void setQueryNow(Date queryNow) {
		this.queryNow = queryNow;
	}
	
	static final String ORDER_BY_COLUMN_ROOM ="房间";
	static final String ORDER_BY_COLUMN_CHECK_IN_TIME="入住时间";
	static final String ORDER_BY_COLUMN_CHECK_OUT_TIME="退房时间";
	static final String ORDER_BY_COLUMN_USE_TIMES="使用次数";
	static final String ORDER_BY_COLUMN_CHARGE="应付款";
	static final String ORDER_BY_COLUMN_CHECK_IN_RECEPTIONIST="入住登记";
	static final String ORDER_BY_COLUMN_CHECK_OUT_RECEPTIONIST="退房登记";	
	static final String ORDER_BY_COLUMN_ROOM_NAME ="ROOM_NO";
	static final String ORDER_BY_COLUMN_CHECK_IN_TIME_NAME="CHECK_IN_TIME";
	static final String ORDER_BY_COLUMN_CHECK_OUT_TIME_NAME="CHECK_OUT_TIME";
	static final String ORDER_BY_COLUMN_USE_TIMES_NAME="USE_TIMES";
	static final String ORDER_BY_COLUMN_CHARGE_NAME="CHARGE";
	static final String ORDER_BY_COLUMN_CHECK_IN_RECEPTIONIST_NAME="CHECK_IN_RECEPTIONIST_NAME";
	static final String ORDER_BY_COLUMN_CHECK_OUT_RECEPTIONIST_NAME="CHECK_OUT_RECEPTIONIST_NAME";
	
	@Override
	protected void buildOrderByColumnMap() {
		Map<String,String> map=getColumnMap();
		map.put(ORDER_BY_COLUMN_ROOM, ORDER_BY_COLUMN_ROOM_NAME);
		map.put(ORDER_BY_COLUMN_CHECK_OUT_TIME, ORDER_BY_COLUMN_CHECK_OUT_TIME_NAME);
		map.put(ORDER_BY_COLUMN_CHECK_IN_TIME, ORDER_BY_COLUMN_CHECK_IN_TIME_NAME);
		map.put(ORDER_BY_COLUMN_USE_TIMES, ORDER_BY_COLUMN_USE_TIMES_NAME);
		map.put(ORDER_BY_COLUMN_CHARGE, ORDER_BY_COLUMN_CHARGE_NAME);
		map.put(ORDER_BY_COLUMN_CHECK_IN_RECEPTIONIST, ORDER_BY_COLUMN_CHECK_IN_RECEPTIONIST_NAME);
		map.put(ORDER_BY_COLUMN_CHECK_OUT_RECEPTIONIST, ORDER_BY_COLUMN_CHECK_OUT_RECEPTIONIST_NAME);
	}
	
}