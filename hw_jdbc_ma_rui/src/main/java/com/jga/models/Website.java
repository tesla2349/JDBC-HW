package com.jga.models;

import java.util.Date;
import java.util.List;

public class Website {
	protected int id;
	protected String name;
	protected String description;
	protected Date created;
	protected Date updated;
	protected int visits;
	protected int developerId;
	protected List<Page> pages;
	
	public String toString() {
		return id+" "+name+" "+description+" "+created+" "+updated+" "+visits+" "+developerId;
	}
	
	public Website(int id, String name, String description, Date created, Date updated, int visits, int developerId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.developerId = developerId;
	}
	public Website() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public void addPage(Page page){
		pages.add(page);
	}
	public void removePage(Page page){
		pages.remove(page);
	}
	
	
}
