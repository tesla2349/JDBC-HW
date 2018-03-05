package com.jga.models;

import java.util.Date;
import java.util.List;

public class Page {
	protected int id;
	protected String title;
	protected String description;
	protected Date created;
	protected Date updated;
	protected int views;
	protected int websiteId;
	protected List<Widget> widgets;
	
	public String toString() {
		return id+" "+title+" "+description+" "+created+" "+updated+" "+views+" "+websiteId;
	}

	public Page(int id, String title, String description, Date created, Date updated, int views, int websiteId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
		this.websiteId = websiteId;
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}
	
	public void addWidget(Widget widget){
		widgets.add(widget);
	}
	public void removeWidget(Widget widget){
		widgets.remove(widget);
	}
		
}
