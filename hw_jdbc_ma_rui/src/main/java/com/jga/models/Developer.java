package com.jga.models;

import java.util.Date;
import java.util.List;

public class Developer extends Person{
	protected int id;
	protected String developerKey;
	protected List<Website> websites;
	
	public String toString() {
		return id+" "+developerKey+" "+firstName+" "+lastName+" "+username+" "+password+" "+email+" "+dob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeveloperKey() {
		return developerKey;
	}
	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}
	public Developer(int id, String developerKey) {
		super();
		this.id = id;
		this.developerKey = developerKey;
	}
	public Developer() {
		super();
	}
	public Developer(int id, String developerKey, String firstName, String lastName, String username, String password, String email,Date dob) {
		super(id, firstName, lastName, username, password, email, dob);
		this.id = id;
		this.developerKey = developerKey;
	}
	
	public void addWebsite(Website website){
		websites.add(website);
	}
	public void removeWebsite(Website website){
		websites.remove(website);
	}
}
