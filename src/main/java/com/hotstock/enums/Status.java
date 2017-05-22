package com.hotstock.enums;

public enum Status {
	
	OPEN(1000),
	SOLD(2000),
	REJECTED(3000);
	
	private int statusId;
	
	private Status(int id) {
		this.statusId = id;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
}
