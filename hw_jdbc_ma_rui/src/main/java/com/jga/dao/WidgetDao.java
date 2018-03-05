package com.jga.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jga.models.Developer;
import com.jga.models.Page;
import com.jga.models.Website;
import com.jga.models.Widget;

public class WidgetDao {
	public static WidgetDao instance=null;
	public static WidgetDao getInstance() {
		if(instance == null) {
			instance=new WidgetDao();
		}
		return instance;
	}
	private WidgetDao() {}
	
	
	public List<Widget> findAllWidgets() {
		List<Widget> widgets = new ArrayList<>();
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "SELECT * FROM Widget";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
	    while(rs.next()){
	          int id  = rs.getInt("id");
	          String name = rs.getString("name");
	          String dtype = rs.getString("dtype");
	          String text = rs.getString("text");
	          int order = rs.getInt("order");
	          int width = rs.getInt("width");
	          int height = rs.getInt("height");
	          String url = rs.getString("url");
	          int pageId = rs.getInt("pageId");
	          Widget widget = new Widget(id,name,dtype,text, order, width, height, url,pageId);
	          widgets.add(widget);
		    }
	    
	    rs.close();
	    stmt.close();
	    conn.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return widgets;
	}
	
	public Widget findWidgetById(int widgetId) {

		Widget widget = null;
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "SELECT * FROM Widget WHERE id=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, widgetId);
		rs = stmt.executeQuery();
	    if(rs.next()){
	          int id  = rs.getInt("id");
	          String name = rs.getString("name");
	          String dtype = rs.getString("dtype");
	          String text = rs.getString("text");
	          int order = rs.getInt("order");
	          int width = rs.getInt("width");
	          int height = rs.getInt("height");
	          String url = rs.getString("url");
	          int pageId = rs.getInt("pageId");
	          widget = new Widget(id,name,dtype,text, order, width, height, url,pageId);
		    }
	    
	    rs.close();
	    stmt.close();
	    conn.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return widget;
	}
	
	public List<Widget> findWidgetsForPage(int i) {
		List<Widget> widgets = new ArrayList<>();
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "SELECT * FROM Widget WHERE pageId=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, i);
		rs = stmt.executeQuery();
	    while(rs.next()){
	          int id  = rs.getInt("id");
	          String name = rs.getString("name");
	          String dtype = rs.getString("dtype");
	          String text = rs.getString("text");
	          int order = rs.getInt("order");
	          int width = rs.getInt("width");
	          int height = rs.getInt("height");
	          String url = rs.getString("url");
	          int pageId = rs.getInt("pageId");
	          Widget widget = new Widget(id,name,dtype,text, order, width, height, url,pageId);
	          widgets.add(widget);
		    }
	    
	    rs.close();
	    stmt.close();
	    conn.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return widgets;
	}
	
			
	public void createWidgetForPage(int pageId, Widget widget) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "INSERT INTO Widget (`id`, `name`, `dtype`, `text`, `order`, `width`, `height`, `url`, `pageId`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, widget.getId());
		stmt.setString(2, widget.getName());
		stmt.setString(3, widget.getDtype());
		stmt.setString(4, widget.getText());
		stmt.setInt(5, widget.getOrder());
		stmt.setInt(6, widget.getWidth());
		stmt.setInt(7, widget.getHeight());
		stmt.setString(8, widget.getUrl());
		stmt.setInt(9, pageId);
		stmt.executeUpdate();
		
	    stmt.close();
	    conn.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
	
	
	public void deleteWidget(int i) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
		String sql = "DELETE FROM Widget WHERE id=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, i);
		stmt.executeUpdate();		
	    
	    stmt.close();
	    conn.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
	public void updateWidget(int i, Widget widget) {

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
		String sql = "UPDATE Widget SET `id`=?,`name` = ?,`dtype` = ?, `text` = ?,`order` = ?,`width` = ?,`height` = ?, `url` = ?, `pageId` = ? WHERE `id`= ?";
		stmt = conn.prepareStatement(sql);
		stmt = conn.prepareStatement(sql);
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, widget.getId());
		stmt.setString(2, widget.getName());
		stmt.setString(3, widget.getDtype());
		stmt.setString(4, widget.getText());
		stmt.setInt(5, widget.getOrder());
		stmt.setInt(6, widget.getWidth());
		stmt.setInt(7, widget.getHeight());
		stmt.setString(8, widget.getUrl());
		stmt.setInt(9, widget.getPageId());
		stmt.setInt(10, i);
		stmt.executeUpdate();    
	    stmt.close();
	    conn.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}

}
