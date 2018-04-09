package com.uc.bpg.forms;

import java.util.Date;

public class ChargingQueryForm extends QueryFormBase {	
	private String queryReceptionistName;
	private Date queryChargingTimeFrom;
	private Date queryChargingTimeTo;
	public Date getQueryChargingTimeFrom() {
		return queryChargingTimeFrom;
	}
	public void setQueryChargingTimeFrom(Date queryChargingTimeFrom) {
		this.queryChargingTimeFrom = queryChargingTimeFrom;
	}
	public Date getQueryChargingTimeTo() {
		return queryChargingTimeTo;
	}
	public void setQueryChargingTimeTo(Date queryChargingTimeTo) {
		this.queryChargingTimeTo = queryChargingTimeTo;
	}
	public String getQueryReceptionistName() {
		return queryReceptionistName;
	}
	public void setQueryReceptionistName(String queryReceptionistName) {
		this.queryReceptionistName = queryReceptionistName;
	}
	
}