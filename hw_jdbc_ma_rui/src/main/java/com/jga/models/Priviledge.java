package com.jga.models;

public class Priviledge {
	protected int id;
	protected int developerId;
	protected int websiteId;
	protected int pageId;
	protected String dtype;
	public Priviledge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Priviledge(int id, int developerId, int websiteId, int pageId, String dtype) {
		super();
		this.id = id;
		this.developerId = developerId;
		this.websiteId = websiteId;
		this.pageId = pageId;
		this.dtype = dtype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	public int getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	
	
	
}
