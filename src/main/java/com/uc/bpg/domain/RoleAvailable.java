package com.uc.bpg.domain;

public class RoleAvailable extends Role  {
	private boolean available;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
