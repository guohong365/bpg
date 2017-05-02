package com.uc.bpg.domain;

import java.util.Date;

public class CheckIn  {
	private Long id;
	private String uuid;
	private Long hotel;
	private Long room;
	private Date checkInTime;
	private Long checkInReceptionist;
	private Date checkOutTime;
	private Long checkOutReceptionist;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
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