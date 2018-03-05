package com.jga.models;

public class Widget {
	protected int id;
	protected String name;
	protected String dtype;
	protected String text;
	protected int order;
	protected int width;
	protected int height;
	protected String url;
	protected int pageId;
	
	public String toString() {
		return id+" "+name+" "+dtype+" "+text+" "+order+" "+width+" "+height+" "+url+" "+pageId;
	}

	public Widget() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Widget(int id, String name, String dtype, String text, int order, int width, int height, String url,int pageId) {
		super();
		this.id = id;
		this.name = name;
		this.dtype = dtype;
		this.text = text;
		this.order = order;
		this.width = width;
		this.height = height;
		this.url = url;
		this.pageId = pageId;
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

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
}
