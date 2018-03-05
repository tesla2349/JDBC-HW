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

public class PageDao {
	public static PageDao instance=null;
	public static PageDao getInstance() {
		if(instance == null) {
			instance=new PageDao();
		}
		return instance;
	}
	private PageDao() {}
	
	
	public List<Page> findAllPages() {
		List<Page> pages = new ArrayList<>();
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
		String sql = "SELECT * FROM Page";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
	    while(rs.next()){
	          int id  = rs.getInt("id");
	          String title = rs.getString("title");
	          String description = rs.getString("description");
	          Date created = rs.getDate("created");
	          Date updated = rs.getDate("updated");
	          int views = rs.getInt("views");
	          int websiteId = rs.getInt("websiteId");
	          Page page = new Page(id,title,description, created, updated, views, websiteId);
	          pages.add(page);
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
	return pages;
	}
	
	public Page findPageById(int pageId) {

		Page page = null;
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
		String sql = "SELECT * FROM Page WHERE id=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, pageId);
		rs = stmt.executeQuery();
	    if(rs.next()){
	          int id  = rs.getInt("id");
	          String title = rs.getString("title");
	          String description = rs.getString("description");
	          Date created = rs.getDate("created");
	          Date updated = rs.getDate("updated");
	          int views = rs.getInt("views");
	          int websiteId = rs.getInt("websiteId");
	          page = new Page(id,title,description, created, updated, views, websiteId);
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
	return page;
	}
	
	public List<Page> findPagesForWebsite(int i) {
		List<Page> pages = new ArrayList<>();
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
		String sql = "SELECT * FROM Page WHERE websiteId=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, i);
		rs = stmt.executeQuery();
	    while(rs.next()){
	          int id  = rs.getInt("id");
	          String title = rs.getString("title");
	          String description = rs.getString("description");
	          Date created = rs.getDate("created");
	          Date updated = rs.getDate("updated");
	          int views = rs.getInt("views");
	          int websiteId = rs.getInt("websiteId");
	          Page page = new Page(id,title,description, created, updated, views, websiteId);
	          pages.add(page);
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
	return pages;
	}
	
			
	public void createPageForWebsite(int websiteId, Page page) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "INSERT INTO Page (id,title,description,created,updated,views,websiteId) VALUES(?,?,?,?,?,?,?)";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, page.getId());
		stmt.setString(2, page.getTitle());
		stmt.setString(3, page.getDescription());
		stmt.setDate(4, (Date) page.getCreated());
		stmt.setDate(5, (Date) page.getUpdated());
		stmt.setInt(6, page.getViews());
		stmt.setInt(7, websiteId);
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
	
	
	public void deletePage(int i) {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
		String sql = "DELETE FROM Page WHERE id=?";
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
	public void updatePage(int i, Page page) {

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-ma.cvxyhvaaaybp.us-east-2.rds.amazonaws.com/hw2_ma_rui_spring_2018";
		final String USERNAME = "marui";
		final String PASSWORD = "Aa84061776";
		Connection conn = null;
		PreparedStatement stmt = null;
	
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		
		String sql = "UPDATE Page SET id=?,title = ?,description = ?,created = ?,updated = ?,views = ?,websiteId = ? WHERE id= ?";
		stmt = conn.prepareStatement(sql);
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, page.getId());
		stmt.setString(2, page.getTitle());
		stmt.setString(3, page.getDescription());
		stmt.setDate(4, (Date) page.getCreated());
		stmt.setDate(5, (Date) page.getUpdated());
		stmt.setInt(6, page.getViews());
		stmt.setInt(7, page.getWebsiteId());
		stmt.setInt(8, i);
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
