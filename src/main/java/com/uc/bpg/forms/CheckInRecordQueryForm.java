package com.uc.bpg.forms;

import java.util.Date;


public class CheckInRecordQueryForm  extends QueryFormBase {
	private Long hotel;
	private Long room;
	private Long strategy;
	private Date checkInTime;
	private Long checkInReceptionist;
	private Date checkOutTime;
	private Long checkOutReceptionist;
	public Long getHotel() {
		return hotel;
	}
	public void setHotel(Long hotel) {
		this.hotel = hotel;
	}
	public Long getRoom() {
		return room;
	}
	public void setRoom(Long room) {
		this.room = room;
	}
	public Long getStrategy() {
		return strategy;
	}
	public void setStrategy(Long strategy) {
		this.strategy = strategy;
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public Long getCheckInReceptionist() {
		return checkInReceptionist;
	}
	public void setCheckInReceptionist(Long checkInReceptionist) {
		this.checkInReceptionist = checkInReceptionist;
	}
	public Date getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public Long getCheckOutReceptionist() {
		return checkOutReceptionist;
	}
	public void setCheckOutReceptionist(Long checkOutReceptionist) {
		this.checkOutReceptionist = checkOutReceptionist;
	}
	
}