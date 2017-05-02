package com.uc.bpg.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.uc.web.domain.EntityBase;


public class Charging  extends EntityBase {
	private Long id;
	private String uuid;
	private Long checkIn;
	private BigDecimal chagre;
	private Long receptionist;
	private Date chargingTime;
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
	
	public BigDecimal getChagre() {
		return chagre;
	}
	public void setChagre(BigDecimal chagre) {
		this.chagre = chagre;
	}
	public Long getReceptionist() {
		return receptionist;
	}
	public void setReceptionist(Long receptionist) {
		this.receptionist = receptionist;
	}
	public Date getChargingTime() {
		return chargingTime;
	}
	public void setChargingTime(Date chargingTime) {
		this.chargingTime = chargingTime;
	}
	public Long getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Long checkIn) {
		this.checkIn = checkIn;
	}

}