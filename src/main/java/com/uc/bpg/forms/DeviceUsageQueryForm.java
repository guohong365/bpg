package com.uc.bpg.forms;

import java.util.Date;
import java.util.Map;


public class DeviceUsageQueryForm extends DetailListQueryFormImpl {
	private Date queryUseTimeFrom;
	private Date queryUseTimeTo;
	private String queryHotelName;
	private Boolean queryPayed;
	private Boolean queryInBill;
	private String queryRoomNo;
	public Date getQueryUseTimeFrom() {
		return queryUseTimeFrom;
	}
	public void setQueryUseTimeFrom(Date queryUseTimeFrom) {
		this.queryUseTimeFrom = queryUseTimeFrom;
	}
	public Date getQueryUseTimeTo() {
		return queryUseTimeTo;
	}
	public void setQueryUseTimeTo(Date queryUseTimeTo) {
		this.queryUseTimeTo = queryUseTimeTo;
	}
	public String getQueryHotelName() {
		return queryHotelName;
	}
	public void setQueryHotelName(String queryHotelName) {
		this.queryHotelName = queryHotelName;
	}
	public Boolean getQueryPayed() {
		return queryPayed;
	}
	public void setQueryPayed(Boolean queryPayed) {
		this.queryPayed = queryPayed;
	}
	public Boolean getQueryInBill() {
		return queryInBill;
	}
	public void setQueryInBill(Boolean queryInBill) {
		this.queryInBill = queryInBill;
	}
	public String getQueryRoomNo() {
		return queryRoomNo;
	}
	public void setQueryRoomNo(String queryRoomNo) {
		this.queryRoomNo = queryRoomNo;
	}
	static final String ORDER_BY_COLUMN_ROOM_NO="房间";
	static final String ORDER_BY_COLUMN_USE_TIME="使用时间";
	static final String ORDER_BY_COLUMN_SERIAL_NO="序列号";
	static final String ORDER_BY_COLUMN_PAYED="已结账";
	static final String ORDER_BY_COLUMN_ROOM_NO_NAME="ROOM_NO";
	static final String ORDER_BY_COLUMN_USE_TIME_NAME="USE_TIME";	
	static final String ORDER_BY_COLUMN_SERIAL_NO_NAME="DEVICE_SERIAL";
	static final String ORDER_BY_COLUMN_PAYED_NAME="PAYED";
	@Override
	protected void buildOrderByColumnMap() {
		Map<String, String> map=getColumnMap();
		map.put(ORDER_BY_COLUMN_ROOM_NO, ORDER_BY_COLUMN_ROOM_NO_NAME);
		map.put(ORDER_BY_COLUMN_USE_TIME, ORDER_BY_COLUMN_USE_TIME_NAME);
		map.put(ORDER_BY_COLUMN_SERIAL_NO, ORDER_BY_COLUMN_SERIAL_NO_NAME);
		map.put(ORDER_BY_COLUMN_PAYED, ORDER_BY_COLUMN_PAYED_NAME);
	}
}