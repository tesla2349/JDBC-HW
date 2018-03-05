package com.jga.models;

public class Phone {
	protected int id;
	protected String phone;
	protected boolean primary;
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Phone(int id, String phone, boolean primary) {
		super();
		this.id = id;
		this.phone = phone;
		this.primary = primary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	
}
